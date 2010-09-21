package org.fiveloyds.cookbook.dao;

import java.io.File;
import java.util.List;

import junit.framework.TestCase;

import org.fiveloyds.cookbook.domain.CookingUnit;
import org.fiveloyds.cookbook.domain.Ingredient;
import org.fiveloyds.cookbook.domain.JAXBCookbookMarshaller;
import org.fiveloyds.cookbook.domain.Recipe;

public class XMLBasedCookbookDAOTest extends TestCase {

	public void testFindRecipesByIngredient() {
		XMLBasedCookbookDAO testDAO = new XMLBasedCookbookDAO();
		testDAO.setMarshaller(new JAXBCookbookMarshaller());

		File t = new File("test\\cookbook.xml");
		testDAO.setCookbookDoc(t);

		Ingredient testIngredient = new Ingredient();
		testIngredient.setName("salt");
		testIngredient.setAmount(1);
		testIngredient.setUnits(CookingUnit.CUP);
		
		List<Recipe> recipes = testDAO.findRecipesByIngredient(null, testIngredient);
		
		assertEquals(2, recipes.size());
	}

	public void testFindRecipesByName() {
		fail("Not yet implemented");
	}

	public void testGetCategories() {
		fail("Not yet implemented");
	}

	public void testGetIngredients() {
		fail("Not yet implemented");
	}

	public void testGetRecipesForCategory() {
		fail("Not yet implemented");
	}

	public void testLoadCookbook() {
		fail("Not yet implemented");
	}

	public void testSaveCookbook() {
		fail("Not yet implemented");
	}

}
