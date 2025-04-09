package com.ndv.blog.controllers;

import com.ndv.blog.domain.TagResponse;
import com.ndv.blog.domain.entities.Tag;
import com.ndv.blog.mappers.TagMapper;
import com.ndv.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
