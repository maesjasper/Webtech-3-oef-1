package edu.ap.xml;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLParser {

	private String INPUT_FILE = "Bestellingen.xml";

	public String getBestellingen() {

		File inputFile = new File(INPUT_FILE);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			String result = "<h2>bestellingen</h2>";

			NodeList bestellingen = doc.getElementsByTagName("bestelling");
			
			for (int i = 0; i < bestellingen.getLength(); i++) {

				Node nNode = bestellingen.item(i);
				Element eElement = (Element) nNode;
				
				System.out.print(eElement.getAttribute("naamKlant"));
				
				result += "<br/><b>naam klant : </b>" + eElement.getAttribute("naamKlant");
				result += "<br/><b>adres : </b>" + eElement.getAttribute("adres");
				result += "<br/><b>datum bestelling : </b>" + eElement.getAttribute("datumBestelling");
				result += "<br/><b>product naam : </b>" + eElement.getAttribute("produktNaam");
				result += "<br/><b>hoeveelheid : </b>" + eElement.getAttribute("hoeveelheid");

				result += "<br/>";
			}

			return result;

		} catch (Exception e) {
			return e.getMessage();
		}

	}
	
	public String addBestelling(String xml)
	{
		File inputFile = new File(INPUT_FILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       
        dbFactory.setValidating(false);
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
	        Document doc2 = dBuilder.parse(new InputSource(new StringReader(xml)));
	        Element element = (Element) doc2.getDocumentElement();
	        
	        Node copiedNode = doc1.importNode(element, true);
	  
	        doc1.getDocumentElement().appendChild(copiedNode);
	        
	        
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUT_FILE));
			transformer.transform(source, result);
	        
	        return this.getBestellingen();
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}	

}
