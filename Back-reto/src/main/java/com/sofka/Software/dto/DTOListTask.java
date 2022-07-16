package com.sofka.Software.dto;

import java.io.Serializable;

public class DTOListTask implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Boolean completed;

    public DTOListTask() {
        super();
    }

    public DTOListTask(Long id, String name, Boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
