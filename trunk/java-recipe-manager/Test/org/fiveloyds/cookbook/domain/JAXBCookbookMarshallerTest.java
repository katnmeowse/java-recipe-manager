package org.fiveloyds.cookbook.domain;

import java.io.File;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;

public class JAXBCookbookMarshallerTest extends TestCase {

	public void testMarshaller() {
		try {
			String xmlString = FileUtils.readFileToString(new File(
					"com/fiveloyds/cookbook/domain/cookbook.xml"));

			JAXBCookbookMarshaller marshaller = new JAXBCookbookMarshaller();
			Cookbook c = marshaller.createCookbookFromXMLString(xmlString);
			String XML = marshaller.convertCookbookToXMLString(c);

			assertEquals(xmlString, XML);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
