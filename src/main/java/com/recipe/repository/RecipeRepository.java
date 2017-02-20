package com.recipe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.domain.Recipe;

@Transactional
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}
