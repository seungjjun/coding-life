package com.junstudio.redis.models;

import com.junstudio.redis.dtos.PostDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    public Post() {
    }

    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public PostDto toDto() {
        return new PostDto(title, content);
    }
}
