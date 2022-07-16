package com.sofka.Software.dto;

import com.sofka.Software.models.ListTaskModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DTOList implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private List<DTOListTask> ListTask = new ArrayList<>();

    public DTOList() {

    }

    public DTOList(String name, List<DTOListTask> listTask) {
        this.name = name;
        ListTask = listTask;
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

    public List<DTOListTask> getListTask() {
        return ListTask;
    }

    public void setListTask(List<DTOListTask> listTask) {
        ListTask = listTask;
    }


}
