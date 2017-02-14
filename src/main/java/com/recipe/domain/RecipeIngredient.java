package com.recipe.domain;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="recipeingredient")
public class RecipeIngredient {

	@EmbeddedId
	private RecipeIngredientId id;

	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="quantityunit")
	private VolumeUnit quantityUnit;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationDate;

	public RecipeIngredient() {
		super();
	}

	public RecipeIngredient(RecipeIngredientId id, Integer quantity, VolumeUnit quantityUnit) {
		this.id = id;
		this.quantity = quantity;
		this.quantityUnit = quantityUnit;
	}

	public RecipeIngredientId getId() {
		return id;
	}

	public void setId(RecipeIngredientId id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public VolumeUnit getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(VolumeUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public Date getModificationDate() {
		return modificationDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		RecipeIngredient other = (RecipeIngredient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
