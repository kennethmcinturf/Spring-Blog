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
        public String postForm(Model model) {
            model.addAttribute("post", new Post());
            return "posts/create";
        }

        @RequestMapping(path = "/posts/create")
        @PostMapping
        public String createPost(@ModelAttribute Post post) {
            Post newPost = new Post();
            newPost.setTitle(post.getTitle());
            newPost.setBody(post.getBody());
            postService.create(newPost);
            return "redirect:http://localhost:8080/posts";
        }

        @RequestMapping(path = "/posts/{id}/edit", method = RequestMethod.GET)
        public String goToEditForm(Model model, @PathVariable int id) {
            Post post = postService.one(id);
            model.addAttribute("post", post);
            return "posts/edit";
        }

        @RequestMapping(path = "/posts/{id}/delete", method = RequestMethod.GET)
        public String deletePost(@PathVariable int id) {
            postService.delete(id);
            return "redirect:http://localhost:8080/posts";
        }

        @RequestMapping(path = "/posts/{id}/edit", method = RequestMethod.POST)
        public String editForm(@PathVariable int id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
            postService.edit(id,title,body);
            return "redirect:http://localhost:8080/posts/" + id;
        }
    }

}
