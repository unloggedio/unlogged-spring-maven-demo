package org.unlogged.demo.resttemplate;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class PostsClient {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
    private final RestTemplate restTemplate;

    public PostsClient() {
        restTemplate = new RestTemplate();
    }

    public List<Post> findAll() {
        try {
            Post[] postsArray = restTemplate.getForObject(BASE_URL, Post[].class);
            return Arrays.asList(postsArray);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch posts", e);
        }
    }

    public String findById(int id) {
        try {
            return restTemplate.getForObject(BASE_URL + "/" + id, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch post with id " + id, e);
        }
    }
}
