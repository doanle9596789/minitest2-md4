package com.example.minitest2md4.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = Painting.class)
    private List<Painting>list;

    public Category() {
    }

    public Category(Long id, String name, List<Painting> list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public Category(String name, List<Painting> list) {
        this.name = name;
        this.list = list;
    }

    public Category(List<Painting> list) {
        this.list = list;
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

    public List<Painting> getList() {
        return list;
    }

    public void setList(List<Painting> list) {
        this.list = list;
    }
}
