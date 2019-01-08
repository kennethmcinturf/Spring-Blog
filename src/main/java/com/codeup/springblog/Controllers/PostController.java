package com.codeup.springblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PostController {
    @Controller
    class controlPost{
        @RequestMapping(path = "/posts", method = RequestMethod.GET)
        public String post(Model model) {
            Post post1 = new Post("Post One", "This is my new posts");
            Post post2 = new Post("Post Two", "Here's some other stuff");
            Post[] posts = {post1,post2};
            model.addAttribute("posts", posts);
            return "index";
        }

        @RequestMapping(path = "/posts/{title}", method = RequestMethod.GET)
        public String indivPost(@PathVariable String title, Model model) {
            Post post1 = new Post("Post One", "This is my new posts");
            model.addAttribute("post", post1);
            return "show";
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
