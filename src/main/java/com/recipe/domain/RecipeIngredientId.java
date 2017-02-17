package com.recipe.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RecipeIngredientId implements Serializable {

	private static final long serialVersionUID = -6148492350730393781L;

	@Column(name="recipeid")
	public Integer recipeId;

	@Column(name="ingredientid")
	public Integer ingredientId;
	
	public RecipeIngredientId() {
		super();
	}

	public RecipeIngredientId(Integer recipeId, Integer ingredientId) {
		this.recipeId = recipeId;
		this.ingredientId = ingredientId;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public Integer getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredientId == null) ? 0 : ingredientId.hashCode());
		result = prime * result + ((recipeId == null) ? 0 : recipeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeIngredientId other = (RecipeIngredientId) obj;
		if (ingredientId == null) {
			if (other.ingredientId != null)
				return false;
		} else if (!ingredientId.equals(other.ingredientId))
			return false;
		if (recipeId == null) {
			if (other.recipeId != null)
				return false;
		} else if (!recipeId.equals(other.recipeId))
			return false;
		return true;
	}
	
}
