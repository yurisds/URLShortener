package com.urlShortener.DTO.RoleDTO;

public class RoleDTO {

    private short id;

    private String name;

    public RoleDTO() {
    }

    public RoleDTO(short id, String name) {
        this.id = id;
        this.name = name;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
