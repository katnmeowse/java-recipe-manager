package org.fiveloyds.cookbook.domain;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Category> {

	private final RecipeComparator _recipeComparator = new RecipeComparator();

	public RecipeComparator getRecipeComparator() {
		return _recipeComparator;
	}
	
	@Override
	public int compare(Category o1, Category o2) {
		// TODO Auto-generated method stub
		return 0;
		
	}

}
