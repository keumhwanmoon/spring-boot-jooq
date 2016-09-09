package com.jason.controller;

import com.jason.domain.Post;
import com.jason.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jason, Moon
 * @since 2016. 9. 9.
 */
@Controller
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping(value = "/blog")
    @ResponseBody
    public List<Post> getAllPost() {
        return blogService.getAllPost();
    }

    @PostMapping(value = "/blog")
    @ResponseBody
    public Post createPost(@RequestBody Post post) {
        return blogService.createPost(post);
    }

}
