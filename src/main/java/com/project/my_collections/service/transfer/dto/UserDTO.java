package com.project.my_collections.service.transfer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.my_collections.model.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class UserDTO {

    private Long id;

    @Size(min = 3, message = "name must be more than 3 symbols")
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 2, message = "password must be more than 3 symbols")
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 2, message = "password must be more than 3 symbols")
    private String passwordConfirm;

    @Email(message = "enter correct email!")
    private String email;

    private boolean isBlocked;

    private Set<Role> roles;
    private List<CollectionDTO> collections;
    private List<CommentDTO> comments;
    private Set<LikeDTO> likes;


    public UserDTO() {
    }

    public UserDTO( String name,  String password, String passwordConfirm, String email) {
        this.name = name;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<CollectionDTO> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionDTO> collections) {
        this.collections = collections;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public Set<LikeDTO> getLikes() {
        return likes;
    }

    public void setLikes(Set<LikeDTO> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", email='" + email + '\'' +
                ", isBlocked=" + isBlocked +
                ", roles=" + roles +
                ", collections=" + collections +
                ", comments=" + comments +
                ", likes=" + likes +
                '}';
    }
}
