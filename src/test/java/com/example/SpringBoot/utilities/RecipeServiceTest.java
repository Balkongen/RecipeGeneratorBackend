package com.example.SpringBoot.utilities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataMongoTest
class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;

    @MockBean
    private RecipeRepository mockRepository;

    private List<Recipe> getMockRecipes() {
        return new ArrayList<>(List.of(
                new Recipe("A", new String[]{"A", "B", "C"}, "ABC"),
                new Recipe("B", new String[]{"B", "C", "D"}, "BCD")
        ));
    }

    @Test
    void getAllRecipes_shouldReturnAll() {
        when(mockRepository.findAll()).thenReturn(getMockRecipes());

        assertEquals(getMockRecipes(), recipeService.getAllRecipes());
    }

}