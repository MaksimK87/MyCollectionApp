package com.project.my_collections.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcollection")
    private long id;

    private String name;
    private String description;
    private String image;
    @Enumerated(EnumType.STRING)
    private Subject type;

    @Column(name = "custom_number_field1")
    private String customNumberField1;
    @Column(name = "custom_number_field2")
    private String customNumberField2;
    @Column(name = "custom_number_field3")
    private String customNumberField3;

    @Column(name = "custom_date_field1")
    private String customDateField1;
    @Column(name = "custom_date_field2")
    private String customDateField2;
    @Column(name = "custom_date_field3")
    private String customDateField3;
    @Column(name = "custom_text_field1")
    private String customTextField1;
    @Column(name = "custom_text_field2")
    private String customTextField2;
    @Column(name = "custom_text_field3")
    private String customTextField3;

    @Column(name = "custom_line_field1")
    private String customLineField1;
    @Column(name = "custom_line_field2")
    private String customLineField2;
    @Column(name = "custom_line_field3")
    private String customLineField3;

    @Column(name = "custom_boolean_field1")
    private String customBooleanField1;
    @Column(name = "custom_boolean_field2")
    private String customBooleanField2;
    @Column(name = "custom_boolean_field3")
    private String customBooleanField3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "collection", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH,CascadeType.REMOVE})
    List<Item> items;

    public Collection() {
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

    public Subject getType() {
        return type;
    }

    public void setType(Subject type) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return id == that.id &&
                name.equals(that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(image, that.image) &&
                type == that.type &&
                Objects.equals(customNumberField1, that.customNumberField1) &&
                Objects.equals(customNumberField2, that.customNumberField2) &&
                Objects.equals(customNumberField3, that.customNumberField3) &&
                Objects.equals(customDateField1, that.customDateField1) &&
                Objects.equals(customDateField2, that.customDateField2) &&
                Objects.equals(customDateField3, that.customDateField3) &&
                Objects.equals(customTextField1, that.customTextField1) &&
                Objects.equals(customTextField2, that.customTextField2) &&
                Objects.equals(customTextField3, that.customTextField3) &&
                Objects.equals(customLineField1, that.customLineField1) &&
                Objects.equals(customLineField2, that.customLineField2) &&
                Objects.equals(customLineField3, that.customLineField3) &&
                Objects.equals(customBooleanField1, that.customBooleanField1) &&
                Objects.equals(customBooleanField2, that.customBooleanField2) &&
                Objects.equals(customBooleanField3, that.customBooleanField3) &&
                Objects.equals(user, that.user) &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, image, type, customNumberField1, customNumberField2, customNumberField3, customDateField1, customDateField2, customDateField3, customTextField1, customTextField2, customTextField3, customLineField1, customLineField2, customLineField3, customBooleanField1, customBooleanField2, customBooleanField3, user, items);
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", type=" + type +
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
                '}';
    }
}
