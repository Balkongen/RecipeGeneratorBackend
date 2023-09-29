package com.example.SpringBoot.utilities;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

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

    @RequestMapping(value = "/addRecipe", produces = "application/json", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Recipe> addRecipe(@Valid @RequestBody Recipe recipe) {
        recipeRepository.save(recipe);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }
}
