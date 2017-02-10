package com.recipe.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.domain.MealType;
import com.recipe.repository.MealTypeRepository;

@RestController
@RequestMapping("/api")
public class MealTypeController {

	private final MealTypeRepository mealTypeRepository;
	
	@Autowired
	public MealTypeController(MealTypeRepository repository) {
		mealTypeRepository = repository;
	}
	
	@GetMapping("/mealtypes/{id}")
	public MealType getMealType(@PathVariable int id) {
		return mealTypeRepository.findOne(id);
	}
	
	@GetMapping("/mealtypes")
	public Iterable<MealType> getMealTypes() {
		return mealTypeRepository.findAll();
	}
	
	@PostMapping("/mealtypes")
	public MealType createMealType(@RequestBody String mealName) {
		return mealTypeRepository.save(new MealType(mealName));
	}
	
	@DeleteMapping("/mealtypes/{id}")
	public void removeMealType(@PathVariable int id) {
		mealTypeRepository.delete(id);
	}
}
