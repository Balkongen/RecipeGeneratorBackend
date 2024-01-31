package com.example.SpringBoot.Repository;

import com.example.SpringBoot.Model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {

    Recipe findByName(String name);
}
