package com.example.BRDO.services.commets_dto;


public class OneCommentDTO {
    private long id;
    private String body;
    private long postId;
    private UserDTO user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", postId=" + postId +
                ", user=" + user +
                '}';
    }
}
