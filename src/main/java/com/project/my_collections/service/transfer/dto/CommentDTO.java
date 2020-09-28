package com.project.my_collections.service.transfer.dto;

import javax.validation.constraints.NotNull;

public class CommentDTO {

    private long id;

    @NotNull
    private String commentText;
    private String publicationDate;
    private long userId;
    private long itemId;

    public CommentDTO(String commentText) {
        this.commentText = commentText;
    }

    public CommentDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", commentText='" + commentText + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", userId=" + userId +
                ", itemId=" + itemId +
                '}';
    }
}
