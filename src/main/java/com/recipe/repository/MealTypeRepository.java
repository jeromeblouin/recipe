package com.recipe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.recipe.domain.MealType;

public interface MealTypeRepository extends CrudRepository<MealType, Integer> {

	Optional<MealType> findByName(String name);
}
