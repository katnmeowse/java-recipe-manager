package org.fiveloyds.cookbook.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.fiveloyds.cookbook.domain.Category;
import org.fiveloyds.cookbook.domain.Cookbook;
import org.fiveloyds.cookbook.domain.Ingredient;
import org.fiveloyds.cookbook.domain.JAXBCookbookMarshaller;
import org.fiveloyds.cookbook.domain.Recipe;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLBasedCookbookDAO implements CookbookDAO {

	private Document _cookbookDoc;
	private JAXBCookbookMarshaller _marshaller;
	private final XPathFactory _factory = XPathFactory.newInstance();
	private final XPath _xpath = _factory.newXPath();

	public JAXBCookbookMarshaller getMarshaller() {
		return _marshaller;
	}

	public void setMarshaller(JAXBCookbookMarshaller marshaller) {
		_marshaller = marshaller;
	}

	private XPath getXpath() {
		return _xpath;
	}

	private Document getCookbookDoc() {
		return _cookbookDoc;
	}

	public void setCookbookDoc(File cookbookFile) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			_cookbookDoc = builder.parse(cookbookFile.getAbsolutePath());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Recipe> findRecipesByIngredient(Cookbook cookbook,
			Ingredient ingredient) {
		if (getCookbookDoc() == null) {
			throw new IllegalStateException("No cookbook loaded");
		}

		try {
			String xpathExp = "/cookbook/category/recipe[ingredient/@name=\""
					+ ingredient.getName() + "\"]";

			NodeList nodes = (NodeList) getXpath().evaluate(xpathExp,
					getCookbookDoc(), XPathConstants.NODESET);
			List<Recipe> recipes = new ArrayList<Recipe>(nodes.getLength());
			for (int i = 0; i < nodes.getLength(); i++) {
				recipes.add((Recipe) getMarshaller().getObject(nodes.item(i)));
			}

			return recipes;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Recipe> findRecipesByName(Cookbook cookbook,
			Ingredient ingredient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategories(Cookbook cookbook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ingredient> getIngredients(Cookbook cookbook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recipe> getRecipesForCategory(Cookbook cookbook,
			Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cookbook loadCookbook(String cookbookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCookbook(Cookbook cookbook) {
		// TODO Auto-generated method stub

	}

}
