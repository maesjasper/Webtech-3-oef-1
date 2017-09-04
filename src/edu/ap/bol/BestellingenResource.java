package edu.ap.bol;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.ap.xml.XMLParser;

public class BestellingenResource extends ServerResource{

	

	@Get("html")
	public String getBestellingen()
	{
		XMLParser xmlparser = new XMLParser();
		return xmlparser.getBestellingen();
		
	}
	
	@Post("txt")
	public String addBestellingen(String bestelling)
	{
		XMLParser xmlparser = new XMLParser();
		return xmlparser.addBestelling(bestelling);
		
	}
	
}
