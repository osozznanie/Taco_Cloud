package com.example.tacocloud.domain;

import lombok.Data;

@Data
public class Ingredient {
    private final String id;
    private final String name;
    private Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    public Ingredient(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}
