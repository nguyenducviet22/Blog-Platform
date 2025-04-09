package com.ndv.blog.controllers;

import com.ndv.blog.domain.TagResponse;
import com.ndv.blog.domain.dtos.CreateTagsRequest;
import com.ndv.blog.domain.entities.Tag;
import com.ndv.blog.mappers.TagMapper;
import com.ndv.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags(){
        List<Tag> tags = tagService.getTags();
        List<TagResponse> tagResponses = tags.stream().map(tag -> tagMapper.toTagResponse(tag)).toList();
        return ResponseEntity.ok(tagResponses);
    }

    @PostMapping
    public ResponseEntity<List<TagResponse>> createTags(@RequestBody CreateTagsRequest createTagsRequest){
        List<Tag> savedTags = tagService.createTags(createTagsRequest.getNames());
        List<TagResponse> createdTagResponses = savedTags.stream()
                .map(tag -> tagMapper.toTagResponse(tag))
                .toList();
        return new ResponseEntity<>(
                createdTagResponses,
                HttpStatus.CREATED
        );
    }
}
