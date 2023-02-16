package com.junstudio.redis.services;

import com.junstudio.redis.dtos.PostDto;
import com.junstudio.redis.dtos.PostsDto;
import com.junstudio.redis.models.Post;
import com.junstudio.redis.repositories.PostRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Cacheable(value = "postsCache")
    public PostsDto posts() {
        List<PostDto> posts = postRepository.findAll().stream().map(Post::toDto).collect(Collectors.toList());
        return new PostsDto(posts);
    }

    @Cacheable(key = "#postId", value = "post")
    public PostDto findPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();

        return post.toDto();
    }
}
