package com.example.invitation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String prefix;

    public Category() {

    }

    public Category(String name, String prefix)
    {
        this.name = name;
        this.prefix = prefix;
    }

    public long getId()
    {
        return this.id;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Category toEntity() {
        Category entity = new Category();
        entity.setPrefix(prefix);
        entity.setName(name);
        return entity;
    }

    public Category toEntity(Category entity) {
        entity.setPrefix(prefix);
        entity.setName(name);
        return entity;
    }
}
