package com.project.my_collections.service.transfer.dto;

public class LikeDTO {

    private long id;

    private long idItem;

    private long idUser;

    public LikeDTO() {
    }

    public LikeDTO(long idItem, long idUser) {
        this.idItem = idItem;
        this.idUser = idUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "LikeDTO{" +
                "id=" + id +
                ", idItem=" + idItem +
                ", idUser=" + idUser +
                '}';
    }
}
