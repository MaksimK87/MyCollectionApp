package com.project.my_collections.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item_like")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlike")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Like() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return Objects.equals(item, like.item) &&
                Objects.equals(user, like.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, user);
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                '}';
    }
}
