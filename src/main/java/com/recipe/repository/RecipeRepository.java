package com.recipe.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.domain.Recipe;

@Transactional
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

	@Query("select r from Recipe r join fetch r.mealtype mt join fetch r.ingredients ri join fetch ri.ingredient i join fetch ri.quantityUnit qu where r.id = :id")
	Recipe findById(@Param("id") int id);
}
