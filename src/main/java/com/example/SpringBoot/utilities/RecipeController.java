package com.example.SpringBoot.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class RecipeController {


    private List<Recipe> recipes;

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/show_all")
    public List<Recipe> getAllRecipes() {

        recipes = recipeRepository.findAll();  
        return recipes;
    }

    @GetMapping("/getRandRecipe")
    public Recipe getRandomRecipe() {
        if (recipes == null) {
            recipes = recipeRepository.findAll();
        }
        Random random = new Random();
        int upper = recipes.size();

        int rand = random.nextInt(upper);
        return recipes.get(rand);
    }

    @GetMapping("/get/{name}")
    public Recipe getRecipe(@PathVariable String name) {
        recipeRepository.
        return recipeRepository.findByName(name);
    }


}
