package org.fiveloyds.cookbook.domain;

import java.io.File;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

public class JAXBCookbookMarshallerTest extends TestCase {

	public void testMarshaller() {
		try {
			File t = new File(
			"test\\cookbook.xml");
			
			System.out.println(t.getAbsolutePath());
			
			String xmlString = FileUtils.readFileToString(t);

			JAXBCookbookMarshaller marshaller = new JAXBCookbookMarshaller();
			Cookbook c = marshaller.createCookbookFromXMLString(xmlString);
			String XML = marshaller.convertCookbookToXMLString(c);

			System.out.println(XML);
			
			assertEquals(xmlString, XML);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
