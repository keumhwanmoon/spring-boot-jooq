package com.jason.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author jason, Moon
 * @since 2016. 9. 9.
 */
@Getter
@Setter
public class Comment {

    private Integer id;
    private Post post;
    private String name;
    private String email;
    private String content;
    private Timestamp createdOn;
}
