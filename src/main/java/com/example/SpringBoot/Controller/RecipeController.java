package com.example.SpringBoot.Controller;

import com.example.SpringBoot.Model.Recipe;
import com.example.SpringBoot.Service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:5500")
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/recipe/random")
    public Recipe getRandomRecipe() {
        return recipeService.getRandomRecipe();
    }

    @GetMapping("/recipe/{name}")
    public Recipe getRecipe(@PathVariable String name) {
        return recipeService.getRecipe(name);
    }

    @GetMapping("/recipe/{ingredients}")
    public List<Recipe> getRecipeBasedOnIngredients(@PathVariable List<String> ingredients ) {
        return recipeService.getRecipesBasedOnIngredients(ingredients);
    }

    @PostMapping(value = "/recipe", produces = "application/json")
    public ResponseEntity<Recipe> addRecipe(@Valid @RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(savedRecipe, HttpStatus.OK);
    }

    @DeleteMapping(value = "/recipe/{name}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable String name) {
        Recipe recipe = recipeService.deleteRecipe(name);

        if (recipe == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
