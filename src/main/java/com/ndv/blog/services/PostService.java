package com.ndv.blog.services;

import com.ndv.blog.domain.CreatePostRequest;
import com.ndv.blog.domain.UpdatePostRequest;
import com.ndv.blog.domain.entities.Post;
import com.ndv.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<Post> getAllPosts(UUID categoryId, UUID tagId);

    List<Post> getDraftPosts(User user);

    Post createPost(User user, CreatePostRequest createPostRequest);

    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
}
