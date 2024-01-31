package com.example.SpringBoot.Repository;

import com.example.SpringBoot.Model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    Recipe findByName(String name);
}
