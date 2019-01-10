package com.codeup.springblog.Controllers;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
