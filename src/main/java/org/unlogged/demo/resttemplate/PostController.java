package org.unlogged.demo.resttemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A test for RestTemplate
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostsClient postsClient;

    @GetMapping
    public List<Post> getAllPosts() {
        return postsClient.findAll();
    }

    @GetMapping("/{id}")
    public String getPostById(@PathVariable int id) {
        return postsClient.findById(id);
    }
}

