package com.junstudio.redis.dtos;

import java.util.List;

public class PostsDto {
    private List<PostDto> posts;

    public PostsDto() {
    }

    public PostsDto(List<PostDto> posts) {
        this.posts = posts;
    }

    public List<PostDto> getPosts() {
        return posts;
    }
}
