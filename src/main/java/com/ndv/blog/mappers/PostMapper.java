package com.ndv.blog.mappers;

import com.ndv.blog.domain.CreatePostRequest;
import com.ndv.blog.domain.UpdatePostRequest;
import com.ndv.blog.domain.dtos.CreatePostRequestDto;
import com.ndv.blog.domain.dtos.PostDto;
import com.ndv.blog.domain.dtos.UpdatePostRequestDto;
import com.ndv.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "postStatus", source = "status")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);
    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);
}
