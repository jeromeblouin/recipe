package com.recipe.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Recipe {

	@Id
	@SequenceGenerator(name="recipe_sequence", sequenceName="recipe_id_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recipe_sequence")
	private Integer id;

	private String name;
	
	private String author;
	
	@ManyToOne
	@JoinColumn(name="mealtype")
	private MealType mealtype;
	
	@Column(name="preparationduration")
	private Integer preparationDuration;

	@Column(name="bakingduration")
	private Integer bakingDuration;
	
	@OneToMany(mappedBy="recipe", cascade=CascadeType.ALL, targetEntity=RecipeIngredient.class, orphanRemoval=true)
	private Set<RecipeIngredient> ingredients;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creationdate", insertable=false)
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modificationdate")
	private Date modificationDate;

	public Recipe() {
		super();
	}

	public Recipe(String name, String author, MealType mealtype, Integer preparationDuration, Integer bakingDuration) {
		this.name = name;
		this.author = author;
		this.mealtype = mealtype;
		this.preparationDuration = preparationDuration;
		this.bakingDuration = bakingDuration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public MealType getMealtype() {
		return mealtype;
	}

	public void setMealtype(MealType mealtype) {
		this.mealtype = mealtype;
	}

	public Integer getPreparationDuration() {
		return preparationDuration;
	}

	public void setPreparationDuration(Integer preparationDuration) {
		this.preparationDuration = preparationDuration;
	}

	public Integer getBakingDuration() {
		return bakingDuration;
	}

	public void setBakingDuration(Integer bakingDuration) {
		this.bakingDuration = bakingDuration;
	}

	public Set<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	@PreUpdate
	public void preUpdate() {
		modificationDate = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Recipe other = (Recipe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
