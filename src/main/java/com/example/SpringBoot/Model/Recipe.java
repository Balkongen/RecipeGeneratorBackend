package com.example.SpringBoot.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "Recipe")
public class Recipe {

    @Id
    private String id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotEmpty(message = "Ingredient list is mandatory")
    private String[] ingredients;

    @NotBlank(message = "Instructions is mandatory")
    private String instructions;

    public Recipe(String name, String[] ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Recipe() {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != null ? !id.equals(recipe.id) : recipe.id != null) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(ingredients, recipe.ingredients)) return false;
        return instructions != null ? instructions.equals(recipe.instructions) : recipe.instructions == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(ingredients);
        result = 31 * result + (instructions != null ? instructions.hashCode() : 0);
        return result;
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
