package com.recipe.service.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Sets;
import com.recipe.domain.Recipe;
import com.recipe.domain.RecipeIngredient;
import com.recipe.repository.RecipeRepository;

@RestController
@RequestMapping("/api/recipes/{recipeId}/ingredients")
public class RecipeIngredientController {

	
	private final RecipeRepository recipeRepository;
	
	@Autowired
	public RecipeIngredientController(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	@GetMapping
	public Set<RecipeIngredient> getIngredients(@PathVariable int recipeId) {
		Recipe recipe = recipeRepository.findOne(recipeId);
		if(recipe != null) {
			return recipe.getIngredients();
		} else {
			return null;
		}
	}
	
	@PutMapping
	public Recipe updateIngredients(@PathVariable int recipeId, @RequestBody Set<RecipeIngredient> ingredients) {
		Recipe recipe = recipeRepository.findOne(recipeId);
		if(recipe != null) {
			ingredients.stream()
				.forEach(i -> i.getId().setRecipeId(recipeId));
			recipe.getIngredients().clear();
			recipe.getIngredients().addAll(Sets.newHashSet(ingredients));
			return recipeRepository.save(recipe);
		} else {
			return null;
		}
	}
}
