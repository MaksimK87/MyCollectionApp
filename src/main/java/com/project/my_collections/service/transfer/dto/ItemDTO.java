package com.project.my_collections.service.transfer.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public class ItemDTO {

    private long id;

    @NotNull(message = "is required")
    private String name;

    private int customNumberField1;
    private int customNumberField2;
    private int customNumberField3;

    private String customTextField1;
    private String customTextField2;
    private String customTextField3;

    private String customLineField1;
    private String customLineField2;
    private String customLineField3;

    private boolean customBooleanField1;
    private boolean customBooleanField2;
    private boolean customBooleanField3;

    private String customDateField1;
    private String customDateField2;
    private String customDateField3;

    private Set<TagDTO> tags;

    private long collectionId;

    private Set<LikeDTO> likes;

    private List<CommentDTO> comments;

    public ItemDTO() {
    }

    public ItemDTO(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomNumberField1() {
        return customNumberField1;
    }

    public void setCustomNumberField1(int customNumberField1) {
        this.customNumberField1 = customNumberField1;
    }

    public int getCustomNumberField2() {
        return customNumberField2;
    }

    public void setCustomNumberField2(int customNumberField2) {
        this.customNumberField2 = customNumberField2;
    }

    public int getCustomNumberField3() {
        return customNumberField3;
    }

    public void setCustomNumberField3(int customNumberField3) {
        this.customNumberField3 = customNumberField3;
    }

    public String getCustomTextField1() {
        return customTextField1;
    }

    public void setCustomTextField1(String customTextField1) {
        this.customTextField1 = customTextField1;
    }

    public String getCustomTextField2() {
        return customTextField2;
    }

    public void setCustomTextField2(String customTextField2) {
        this.customTextField2 = customTextField2;
    }

    public String getCustomTextField3() {
        return customTextField3;
    }

    public void setCustomTextField3(String customTextField3) {
        this.customTextField3 = customTextField3;
    }

    public String getCustomLineField1() {
        return customLineField1;
    }

    public void setCustomLineField1(String customLineField1) {
        this.customLineField1 = customLineField1;
    }

    public String getCustomLineField2() {
        return customLineField2;
    }

    public void setCustomLineField2(String customLineField2) {
        this.customLineField2 = customLineField2;
    }

    public String getCustomLineField3() {
        return customLineField3;
    }

    public void setCustomLineField3(String customLineField3) {
        this.customLineField3 = customLineField3;
    }

    public boolean isCustomBooleanField1() {
        return customBooleanField1;
    }

    public void setCustomBooleanField1(boolean customBooleanField1) {
        this.customBooleanField1 = customBooleanField1;
    }

    public boolean isCustomBooleanField2() {
        return customBooleanField2;
    }

    public void setCustomBooleanField2(boolean customBooleanField2) {
        this.customBooleanField2 = customBooleanField2;
    }

    public boolean isCustomBooleanField3() {
        return customBooleanField3;
    }

    public void setCustomBooleanField3(boolean customBooleanField3) {
        this.customBooleanField3 = customBooleanField3;
    }

    public String getCustomDateField1() {
        return customDateField1;
    }

    public void setCustomDateField1(String customDateField1) {
        this.customDateField1 = customDateField1;
    }

    public String getCustomDateField2() {
        return customDateField2;
    }

    public void setCustomDateField2(String customDateField2) {
        this.customDateField2 = customDateField2;
    }

    public String getCustomDateField3() {
        return customDateField3;
    }

    public void setCustomDateField3(String customDateField3) {
        this.customDateField3 = customDateField3;
    }

    public Set<TagDTO> getTags() {
        return tags;
    }

    public void setTags(Set<TagDTO> tags) {
        this.tags = tags;
    }

    public long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(long collectionId) {
        this.collectionId = collectionId;
    }

    public Set<LikeDTO> getLikes() {
        return likes;
    }

    public void setLikes(Set<LikeDTO> likes) {
        this.likes = likes;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customNumberField1=" + customNumberField1 +
                ", customNumberField2=" + customNumberField2 +
                ", customNumberField3=" + customNumberField3 +
                ", customTextField1='" + customTextField1 + '\'' +
                ", customTextField2='" + customTextField2 + '\'' +
                ", customTextField3='" + customTextField3 + '\'' +
                ", customLineField1='" + customLineField1 + '\'' +
                ", customLineField2='" + customLineField2 + '\'' +
                ", customLineField3='" + customLineField3 + '\'' +
                ", customBooleanField1=" + customBooleanField1 +
                ", customBooleanField2=" + customBooleanField2 +
                ", customBooleanField3=" + customBooleanField3 +
                ", customDateField1=" + customDateField1 +
                ", customDateField2=" + customDateField2 +
                ", customDateField3=" + customDateField3 +
                ", tags=" + tags +
                ", collection=" + collectionId +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}
