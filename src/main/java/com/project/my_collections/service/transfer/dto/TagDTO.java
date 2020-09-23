package com.project.my_collections.service.transfer.dto;

import java.util.Objects;
import java.util.Set;

public class TagDTO {

    private long id;

    private String tagName;

    private Set<ItemDTO> items;

    public TagDTO(String tagName) {
        this.tagName = tagName;
    }

    public TagDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<ItemDTO> getItems() {
        return items;
    }

    public void setItems(Set<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagDTO tagDTO = (TagDTO) o;
        return id == tagDTO.id &&
                Objects.equals(tagName, tagDTO.tagName) &&
                Objects.equals(items, tagDTO.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName, items);
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", items=" + items +
                '}';
    }
}
