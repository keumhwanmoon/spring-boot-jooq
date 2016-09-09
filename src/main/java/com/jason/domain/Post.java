package com.jason.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jason, Moon
 * @since 2016. 9. 9.
 */
@Getter
@Setter
public class Post {

    private Integer id;
    private String title;
    private String content;
    private Timestamp createdOn;
    private List<Comment> comments = new ArrayList<>();

    public Post(Integer id, String title, String content, Timestamp createdOn) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdOn = createdOn;
    }
}
