package com.example.SpringBoot.utilities;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    Recipe findByName(String name);
    
}
