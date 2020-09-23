package com.project.my_collections.service.transfer.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CollectionDTO {

    private long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    private String image;
    @NotNull
    private String type;

    private String customNumberField1;
    private String customNumberField2;
    private String customNumberField3;
    private String customDateField1;
    private String customDateField2;
    private String customDateField3;
    private String customTextField1;
    private String customTextField2;
    private String customTextField3;
    private String customLineField1;
    private String customLineField2;
    private String customLineField3;
    private String customBooleanField1;
    private String customBooleanField2;
    private String customBooleanField3;

    private long userId;

    List<ItemDTO> items;

    public CollectionDTO() {
    }

    public CollectionDTO(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomNumberField1() {
        return customNumberField1;
    }

    public void setCustomNumberField1(String customNumberField1) {
        this.customNumberField1 = customNumberField1;
    }

    public String getCustomNumberField2() {
        return customNumberField2;
    }

    public void setCustomNumberField2(String customNumberField2) {
        this.customNumberField2 = customNumberField2;
    }

    public String getCustomNumberField3() {
        return customNumberField3;
    }

    public void setCustomNumberField3(String customNumberField3) {
        this.customNumberField3 = customNumberField3;
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

    public String getCustomBooleanField1() {
        return customBooleanField1;
    }

    public void setCustomBooleanField1(String customBooleanField1) {
        this.customBooleanField1 = customBooleanField1;
    }

    public String getCustomBooleanField2() {
        return customBooleanField2;
    }

    public void setCustomBooleanField2(String customBooleanField2) {
        this.customBooleanField2 = customBooleanField2;
    }

    public String getCustomBooleanField3() {
        return customBooleanField3;
    }

    public void setCustomBooleanField3(String customBooleanField3) {
        this.customBooleanField3 = customBooleanField3;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CollectionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", customNumberField1='" + customNumberField1 + '\'' +
                ", customNumberField2='" + customNumberField2 + '\'' +
                ", customNumberField3='" + customNumberField3 + '\'' +
                ", customDateField1='" + customDateField1 + '\'' +
                ", customDateField2='" + customDateField2 + '\'' +
                ", customDateField3='" + customDateField3 + '\'' +
                ", customTextField1='" + customTextField1 + '\'' +
                ", customTextField2='" + customTextField2 + '\'' +
                ", customTextField3='" + customTextField3 + '\'' +
                ", customLineField1='" + customLineField1 + '\'' +
                ", customLineField2='" + customLineField2 + '\'' +
                ", customLineField3='" + customLineField3 + '\'' +
                ", customBooleanField1='" + customBooleanField1 + '\'' +
                ", customBooleanField2='" + customBooleanField2 + '\'' +
                ", customBooleanField3='" + customBooleanField3 + '\'' +
                ", userId=" + userId +
                ", items=" + items +
                '}';
    }
}
