package com.jason.service;

import com.jason.domain.Post;
import com.jason.domain.tables.records.PostsRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.jason.domain.tables.Posts.POSTS;

/**
 * @author jason, Moon
 * @since 2016. 9. 9.
 */
@Service
@Transactional
public class BlogService {

    private final DSLContext dslContext;

    @Autowired
    public BlogService(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<Post> getAllPost() {
        List<Post> posts = new ArrayList<>();

        Result<Record> result = dslContext.select().from(POSTS).fetch();

        for (Record r : result) {
            posts.add(getPostEntity(r));
        }

        return posts;
    }

    public Post createPost(Post post) {
        PostsRecord postsRecord = dslContext.insertInto(POSTS)
                .set(POSTS.TITLE, post.getTitle())
                .set(POSTS.CONTENT, post.getContent())
                .set(POSTS.CREATED_ON, post.getCreatedOn())
                .returning(POSTS.ID)
                .fetchOne();

        post.setId(postsRecord.getId());

        return post;
    }

    private Post getPostEntity(Record r){
        Integer id = r.getValue(POSTS.ID, Integer.class);
        String title = r.getValue(POSTS.TITLE, String.class);
        String content = r.getValue(POSTS.CONTENT, String.class);
        Timestamp createdOn = r.getValue(POSTS.CREATED_ON, Timestamp.class);
        return new Post(id, title, content, createdOn);
    }
}


