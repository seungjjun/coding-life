package com.junstudio.redis;

import com.junstudio.redis.models.Post;
import com.junstudio.redis.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RedisTest {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    void save() {
        Post post = new Post(1L, "title", "content");

        postRepository.save(post);

        Post findPost = postRepository.findById(post.getId()).get();
        assertThat(findPost.getTitle()).isEqualTo("title");

        postRepository.count();
    }
}
