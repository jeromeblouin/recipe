package com.recipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

	Optional<Recipe> findByName(String name);
}
