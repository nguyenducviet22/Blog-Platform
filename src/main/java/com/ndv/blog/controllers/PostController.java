package com.ndv.blog.controllers;

import com.ndv.blog.domain.CreatePostRequest;
import com.ndv.blog.domain.dtos.CreatePostRequestDto;
import com.ndv.blog.domain.dtos.PostDto;
import com.ndv.blog.domain.entities.Post;
import com.ndv.blog.domain.entities.User;
import com.ndv.blog.mappers.PostMapper;
import com.ndv.blog.services.PostService;
import com.ndv.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(required = false) UUID categoryId,
            @RequestParam(required = false) UUID tagId
    ) {
        List<Post> posts = postService.getAllPosts(categoryId, tagId);
        List<PostDto> postDtos = posts.stream().map(post -> postMapper.toDto(post)).toList();
        return ResponseEntity.ok(postDtos);
    }

    @GetMapping("/drafts")
    public ResponseEntity<List<PostDto>> getDrafts(
//            @RequestAttribute UUID userId //Use for logging in via Frontend
            @RequestParam UUID userId //Use for testing via Postman
    ) {
        User loggedInUser = userService.getUserById(userId);
        List<Post> draftPosts = postService.getDraftPosts(loggedInUser);
        List<PostDto> postDtos = draftPosts.stream().map(post -> postMapper.toDto(post)).toList();
        return ResponseEntity.ok(postDtos);

    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @RequestBody CreatePostRequestDto createPostRequestDto,
//            @RequestAttribute UUID userId //Use for logging in via Frontend
            @RequestParam UUID userId //Use for testing via Postman
    ) {
        User loggedInUser = userService.getUserById(userId);
        CreatePostRequest createPostRequest = postMapper.toCreatePostRequest(createPostRequestDto);
        Post createdPost = postService.createPost(loggedInUser, createPostRequest);
        PostDto createPostDto = postMapper.toDto(createdPost);
        return new ResponseEntity<>(createPostDto, HttpStatus.CREATED);
    }
}
