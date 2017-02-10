package com.recipe.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.domain.Ingredient;
import com.recipe.repository.IngredientRepository;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

	private final IngredientRepository ingredientRepository;
	
	@Autowired
	public IngredientController(IngredientRepository repository) {
		ingredientRepository = repository;
	}
	
	@GetMapping("/{id}")
	public Ingredient getIngredient(@PathVariable int id) {
		return ingredientRepository.findOne(id);
	}
	
	@GetMapping
	public Iterable<Ingredient> getIngredients() {
		return ingredientRepository.findAll();
	}
	
	@PostMapping
	public Ingredient createIngredient(@RequestBody String name) {
		return ingredientRepository.save(new Ingredient(name));
	}
	
	@DeleteMapping("/{id}")
	public void removeIngredient(@PathVariable int id) {
		ingredientRepository.delete(id);
	}
}
