package com.sofka.Software.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "listas")
public class ListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(unique = false, nullable = false)
    private String name;
    /**
     * anotacion OneToMany(uno a muchos) permite crear la relacion con la tabla secundaria
     */
    @OneToMany(fetch = FetchType.EAGER,
            targetEntity = ListTaskModel.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "listaid")

    /**
     * referencia la llave foranea de la clase lista tarea modelo
     */
    @JsonBackReference
    private List<ListTaskModel>ListTask = new ArrayList<>();


    public ListModel() {

    }

    public ListModel(String name, List<ListTaskModel> listTask) {
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

    public List<ListTaskModel> getListTask() {
        return ListTask;
    }

    public void setListTask(List<ListTaskModel> listTask) {
        ListTask = listTask;
    }
}
