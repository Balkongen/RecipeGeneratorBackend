package com.example.SpringBoot.utilities;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class RecipeController {


    private final RecipeService recipeService;

    @GetMapping("/show_all")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/getRandRecipe")
    public Recipe getRandomRecipe() {
        return recipeService.getRandomRecipe();
    }

    @GetMapping("/get/{name}")
    public Recipe getRecipe(@PathVariable String name) {
        return recipeService.getRecipe(name);
    }

    @GetMapping("/getRecipeFromIngredients/{ingredientList}")
    public List<Recipe> getRecipeBasedOnIngredients(@PathVariable List<String> ingredientList ) {
        return recipeService.getRecipesBasedOnIngredients(ingredientList);
    }

    @RequestMapping(value = "/addRecipe", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Recipe> addRecipe(@Valid @RequestBody Recipe recipe) {
        Recipe savedRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(savedRecipe, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable String name) {
        Recipe recipe = getRecipe(name);

        if (recipe == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
