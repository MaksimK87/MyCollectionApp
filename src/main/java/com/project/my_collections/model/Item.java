package com.project.my_collections.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(name = "custom_number_field1")
    private int customNumberField1;
    @Column(name = "custom_number_field2")
    private int customNumberField2;
    @Column(name = "custom_number_field3")
    private int customNumberField3;

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
    private boolean customBooleanField1;
    @Column(name = "custom_boolean_field2")
    private boolean customBooleanField2;
    @Column(name = "custom_boolean_field3")
    private boolean customBooleanField3;

    @Column(name = "custom_date_field1")
    private LocalDate customDateField1;
    @Column(name = "custom_date_field2")
    private LocalDateTime customDateField2;
    @Column(name = "custom_date_field3")
    private LocalDateTime customDateField3;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Tag> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_id")
    private MyCollection collection;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = {CascadeType.ALL})
    private Set<Like> likes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = {CascadeType.ALL})
    private List<Comment> comments;

    public Item() {
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

    public LocalDate getCustomDateField1() {
        return customDateField1;
    }

    public void setCustomDateField1(LocalDate customDateField1) {
        this.customDateField1 = customDateField1;
    }

    public LocalDateTime getCustomDateField2() {
        return customDateField2;
    }

    public void setCustomDateField2(LocalDateTime customDateField2) {
        this.customDateField2 = customDateField2;
    }

    public LocalDateTime getCustomDateField3() {
        return customDateField3;
    }

    public void setCustomDateField3(LocalDateTime customDateField3) {
        this.customDateField3 = customDateField3;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public MyCollection getCollection() {
        return collection;
    }

    public void setCollection(MyCollection collection) {
        this.collection = collection;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return customNumberField1 == item.customNumberField1 &&
                customNumberField2 == item.customNumberField2 &&
                customNumberField3 == item.customNumberField3 &&
                customBooleanField1 == item.customBooleanField1 &&
                customBooleanField2 == item.customBooleanField2 &&
                customBooleanField3 == item.customBooleanField3 &&
                Objects.equals(name, item.name) &&
                Objects.equals(customTextField1, item.customTextField1) &&
                Objects.equals(customTextField2, item.customTextField2) &&
                Objects.equals(customTextField3, item.customTextField3) &&
                Objects.equals(customLineField1, item.customLineField1) &&
                Objects.equals(customLineField2, item.customLineField2) &&
                Objects.equals(customLineField3, item.customLineField3) &&
                Objects.equals(customDateField1, item.customDateField1) &&
                Objects.equals(customDateField2, item.customDateField2) &&
                Objects.equals(customDateField3, item.customDateField3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customNumberField1, customNumberField2, customNumberField3, customTextField1, customTextField2, customTextField3, customLineField1, customLineField2, customLineField3, customBooleanField1, customBooleanField2, customBooleanField3, customDateField1, customDateField2, customDateField3);
    }

    @Override
    public String toString() {
        return "Item{" +
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
                '}';
    }
}
