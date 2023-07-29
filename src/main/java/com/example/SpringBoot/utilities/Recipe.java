package com.example.SpringBoot.utilities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "Recipe")
public class Recipe {

    @Id
    private String id;

    private String name;
    private String[] ingredients;
    private String instructions;

    public Recipe(String name, String[] ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
