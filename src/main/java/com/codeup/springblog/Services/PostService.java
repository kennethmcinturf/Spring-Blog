package com.codeup.springblog.Services;

import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postsDao;

    public PostService(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    public List<Post> all() {
        return (List<Post>) postsDao.findAll();
    }

    public Post create(Post post) {
        postsDao.save(post);
        return post;
    }

    public Post one(int id) {
        return postsDao.findOne(id - 1);
    }

    public void delete(int id){
        postsDao.delete(id - 1);
    }

    public void edit(int id, String title, String body){
        Post post = one(id);
        post.setTitle(title);
        post.setBody(body);
        postsDao.save(post);
    }

    private void createPost() {
        Post post = new Post();
        create(post);
    }
}
