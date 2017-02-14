package com.recipe.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RecipeIngredientId implements Serializable {

	private static final long serialVersionUID = 693036606147906421L;

	@ManyToOne
	@JoinColumn(name="recipeid")
	private Integer recipeId;

	@ManyToOne
	@JoinColumn(name="ingredientid")
	private Integer ingredientId;

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

	public Integer getIngredientId() {
		return ingredientId;
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
