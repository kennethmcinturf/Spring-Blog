package com.codeup.springblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Controller
    class controlPost{
        @RequestMapping(path = "/posts", method = RequestMethod.GET)
        public String post(Model model) {
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
            List<Post> posts = postService.all();
            model.addAttribute("posts", posts);
            return "posts/index";
        }

        @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
        public String indivPost(@PathVariable int id, Model model) {
            Post post = postService.one(id);
            model.addAttribute("post", post);
            return "posts/show";
        }

        @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
        @ResponseBody
        public String postForm() {
            return "view the form for creating a post";
        }

        @RequestMapping(path = "/posts/create")
        @PostMapping
        public String createPost() {
            return "create a new post";
        }
    }

}
