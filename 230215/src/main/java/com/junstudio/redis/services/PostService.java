package com.junstudio.redis.services;

import com.junstudio.redis.dtos.PostDto;
import com.junstudio.redis.models.Post;
import com.junstudio.redis.repositories.PostRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Cacheable(value = "post")
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto findPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();

        return post.toDto();
    }
}
