package com.ndv.blog.services.impl;

import com.ndv.blog.domain.entities.Tag;
import com.ndv.blog.repositories.TagRepository;
import com.ndv.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAllWithPostCount();
    }
}
