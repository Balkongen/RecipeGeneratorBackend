package com.example.SpringBoot.Service;


import com.example.SpringBoot.Model.Recipe;
import com.example.SpringBoot.Repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


@RequiredArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe getRandomRecipe() {
        List<Recipe> recipes = recipeRepository.findAll();
        Random random = new Random();

        int upper = recipes.size();
        int rand = random.nextInt(upper);

        return recipes.get(rand);
    }

    public Recipe getRecipe(String name) {
        return recipeRepository.findByName(name);
    }

    public List<Recipe> getRecipesBasedOnIngredients(List<String> ingredientList) {
        final int MINIMUM_NUMBER_OF_INGREDIENTS = 3;

        HashSet<String> ingredients = new HashSet<>(ingredientList);
        List<Recipe> recipes = recipeRepository.findAll();
        List<Recipe> correctRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            String[] ingredientsInRecipe = recipe.getIngredients();
            int count = 0;

            for (String ingredient : ingredientsInRecipe) {
                if (ingredients.contains(ingredient))
                    count++;

                if (count == MINIMUM_NUMBER_OF_INGREDIENTS) {
                    correctRecipes.add(recipe);
                    break;
                }
            }

        }
        return correctRecipes;
    }

    public Recipe addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe;
    }

    public Recipe deleteRecipe(String name) {
        Recipe recipe = getRecipe(name);

        if (recipe == null)
            return null;

        recipeRepository.delete(recipe);

        return recipe;
    }

}
