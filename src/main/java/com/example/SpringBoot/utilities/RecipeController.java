package com.example.SpringBoot.utilities;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/show_all")
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @GetMapping("/getRandRecipe")
    public Recipe getRandomRecipe() {
        List<Recipe> recipes = recipeRepository.findAll();
        Random random = new Random();

        int upper = recipes.size();
        int rand = random.nextInt(upper);

        return recipes.get(rand);
    }

    @GetMapping("/get/{name}")
    public Recipe getRecipe(@PathVariable String name) {
        return recipeRepository.findByName(name);
    }

    @GetMapping("/getRecipeFromIngredients/{ingredientList}")
    public List<Recipe> getRecipeBasedOnIngredients(@PathVariable List<String> ingredientList ) {
        final int MINIMUM_NUMBER_OF_INGREDIENTS = 3;

        HashSet<String> ingredients = new HashSet<>(ingredientList);
        List<Recipe> recipes = recipeRepository.findAll();
        List<Recipe> correctRecipes = new ArrayList<>();

        int count = 0;
        for (Recipe recipe : recipes) {
            String[] ingredientsInRecipe = recipe.getIngredients();
            for (String ingredient : ingredientsInRecipe) {
                if (ingredients.contains(ingredient))
                    count++;

                if (count == MINIMUM_NUMBER_OF_INGREDIENTS)
                    correctRecipes.add(recipe);
            }

        }

        return recipes;
    }

    @RequestMapping(value = "/addRecipe", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Recipe> addRecipe(@Valid @RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable String name) {
        Recipe recipe = getRecipe(name);

        if (recipe == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        recipeRepository.delete(recipe);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
