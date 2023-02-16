package com.junstudio.redis.controllers;

import com.junstudio.redis.dtos.PostDto;
import com.junstudio.redis.dtos.PostsDto;
import com.junstudio.redis.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    private PostsDto posts() {
        return postService.posts();
    }

    @GetMapping("/post/{postId}")
    private PostDto post(
        @PathVariable Long postId
    ) {
        return postService.findPost(postId);
    }
}
