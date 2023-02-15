package com.junstudio.redis.controllers;

import com.junstudio.redis.dtos.PostDto;
import com.junstudio.redis.services.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("{postId}")
    private PostDto posts(
        @PathVariable Long postId
    ) {
        return postService.findPost(postId);
    }
}
