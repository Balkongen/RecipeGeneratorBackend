package com.example.SpringBoot.utilities;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

    Recipe findByName(String name);
}
