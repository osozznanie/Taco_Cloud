package com.example.tacocloud.domain;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;

@Data

public class IngredientRef {

    @Column("ingredient")
    private final String ingredient;


}
