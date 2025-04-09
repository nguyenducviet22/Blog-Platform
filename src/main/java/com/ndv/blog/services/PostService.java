package com.ndv.blog.services;

import com.ndv.blog.domain.entities.Post;
import com.ndv.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<Post> getAllPosts(UUID categoryId, UUID tagId);

    List<Post> getDraftPosts(User user);
}
