package com.codeup.springblog.Controllers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPost();
    }

    public List<Post> all() {
        return posts;
    }

    public Post create(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post one(int id) {
        return posts.get(id - 1);
    }

    private void createPost() {
        Post post = new Post();
        Post post1 = create(post);
    }

    public static void main(String[] args) {
        PostService postService = new PostService();
        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        post1.setTitle("Post One");
        post2.setTitle("Post Two");
        post3.setTitle("Post Three");
        post1.setBody("Here's some content");
        post2.setBody("Here's some more content");
        post3.setBody("Here's even more content");
        postService.create(post1);
        postService.create(post2);
        postService.create(post3);
        List<Post> list = postService.all();
        System.out.println(list.size());
        System.out.println(list.get(0).getTitle());
        System.out.println(list.get(2).getId());
        System.out.println(list.get(3).getId());
    }
}
