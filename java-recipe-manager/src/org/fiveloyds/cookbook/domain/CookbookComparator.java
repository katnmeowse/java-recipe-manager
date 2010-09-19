package org.fiveloyds.cookbook.domain;

import java.util.Comparator;

public class CookbookComparator implements Comparator<Cookbook> {
	private final CategoryComparator _categoryComparator = new CategoryComparator();

	public CategoryComparator getCategoryComparator() {
		return _categoryComparator;
	}

	@Override
	public int compare(Cookbook o1, Cookbook o2) {
		return 0;
	}

}
