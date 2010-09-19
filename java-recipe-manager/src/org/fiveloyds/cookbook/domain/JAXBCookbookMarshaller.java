package org.fiveloyds.cookbook.domain;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBCookbookMarshaller {
	private final Marshaller _marshaller;
	private final Unmarshaller _unmarshaller;

	public Marshaller getMarshaller() {
		return _marshaller;
	}

	public Unmarshaller getUnmarshaller() {
		return _unmarshaller;
	}

	public JAXBCookbookMarshaller() {
		try {
			JAXBContext context = JAXBContext
					.newInstance("org.fiveloyds.cookbook.domain");
			_marshaller = context.createMarshaller();
			_unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}

	}

	public String convertCookbookToXMLString(Cookbook cookbook)
			throws JAXBException {
		StringWriter writer = new StringWriter();
		getMarshaller().marshal(cookbook, writer);
		return writer.toString();
	}

	public Cookbook createCookbookFromXMLString(String xmlString)
			throws JAXBException {
		return (Cookbook) getUnmarshaller().unmarshal(
				new StringReader(xmlString));
	}
}
