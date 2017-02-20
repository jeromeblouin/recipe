package com.recipe.service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.domain.MealType;
import com.recipe.domain.Recipe;
import com.recipe.repository.MealTypeRepository;
import com.recipe.repository.RecipeRepository;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

	private final RecipeRepository recipeRepository;
	private final MealTypeRepository mealTypeRepository;
	
	@Autowired
	public RecipeController(RecipeRepository recipeRepository, MealTypeRepository mealTypeRepository) {
		this.recipeRepository = recipeRepository;
		this.mealTypeRepository = mealTypeRepository;
	}
	
	@GetMapping("/{id}")
	public Recipe getRecipe(@PathVariable int id) {
		return recipeRepository.findById(id);
	}
	
	@GetMapping
	public Iterable<Recipe> getRecipes() {
		return recipeRepository.findAll();
	}
	
	@PostMapping
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		Optional<MealType> mealType = mealTypeRepository.findByName(recipe.getMealtype().getName());
		if(mealType.isPresent()) {
			Recipe newRecipe = new Recipe(recipe.getName(), recipe.getAuthor(), mealType.get(), recipe.getPreparationDuration(), recipe.getBakingDuration());
			return recipeRepository.save(newRecipe);
		} else {
			return null;
		}
	}
	
	@PutMapping("/{id}")
	public Recipe updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
		Recipe updatedRecipe = null;
		
		Recipe foundRecipe = recipeRepository.findOne(id);
		if(foundRecipe != null) {
			recipe.setId(foundRecipe.getId());
			updatedRecipe = recipeRepository.save(recipe);
		}
		
		return updatedRecipe;
	}
	
	@DeleteMapping("/{id}")
	public void removeRecipe(@PathVariable int id) {
		recipeRepository.delete(id);
	}
}
