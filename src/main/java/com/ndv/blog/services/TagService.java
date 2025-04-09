package com.ndv.blog.services;

import com.ndv.blog.domain.entities.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTags();
}
