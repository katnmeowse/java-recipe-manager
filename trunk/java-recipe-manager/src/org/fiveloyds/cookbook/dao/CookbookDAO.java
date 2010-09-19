package org.fiveloyds.cookbook.dao;

import org.fiveloyds.cookbook.domain.Cookbook;

public interface CookbookDAO {
	public Cookbook loadCookbook(String cookbookName);
	public void saveCookbook(Cookbook cookbook);
}
