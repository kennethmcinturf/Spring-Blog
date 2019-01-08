package com.codeup.springblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @Controller
    class controlPost{
        @RequestMapping(path = "/posts", method = RequestMethod.GET)
        @ResponseBody
        public String post() {
            return "posts index page";
        }

        @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
        @ResponseBody
        public String indivPost(@PathVariable long id) {
            return "view an individual post " + id;
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
