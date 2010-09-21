package org.fiveloyds.cookbook.dao;

import java.util.List;

import org.fiveloyds.cookbook.domain.Category;
import org.fiveloyds.cookbook.domain.Cookbook;
import org.fiveloyds.cookbook.domain.Ingredient;
import org.fiveloyds.cookbook.domain.Recipe;

public interface CookbookDAO {
	public Cookbook loadCookbook(String cookbookName);
	public void saveCookbook(Cookbook cookbook);
	public List<Category> getCategories(Cookbook cookbook);
	public List<Recipe> getRecipesForCategory(Cookbook cookbook, Category category);
	public List<Recipe> findRecipesByIngredient(Cookbook cookbook, Ingredient ingredient);
	public List<Recipe> findRecipesByName(Cookbook cookbook, Ingredient ingredient);
	public List<Ingredient> getIngredients(Cookbook cookbook);
}
