package com.example.BRDO.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Long id;

    @Column(name = "body")
    private String body;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "username")
    private String username;

    @Column(name = "updated_at")
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void getUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public String getUpdatedAtFormat() {
        String pattern = "dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(this.updatedAt);
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

}
