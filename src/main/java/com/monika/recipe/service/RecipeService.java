package com.monika.recipe.service;

import com.monika.recipe.model.Recipe;
import com.monika.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository repo;

    public List<Recipe> getAllRecipes() {
        return repo.findAll();
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return repo.findById(id);
    }

    public Recipe saveRecipe(Recipe recipe) {
        return repo.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        if (recipe.getId() != null && repo.existsById(recipe.getId())) {
            return repo.save(recipe);
        }
        throw new IllegalArgumentException("Recipe ID must be set to update");
    }

    public void deleteRecipeById(Long id) {
        repo.deleteById(id);
    }
}