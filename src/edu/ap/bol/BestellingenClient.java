package edu.ap.bol;

import org.restlet.resource.ClientResource;

public class BestellingenClient {

	public static void main(String[] args) {

		try {

			ClientResource clientResource = new ClientResource("http://localhost:8087/bestellingen");

			String bestelling1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";

			bestelling1 += "<bestelling naamKlant =\"Jasper Maes2\" adres =\"Schensbossen 10\" datumBestelling =\"23/07/1994\" produktNaam =\"1 TB Harddrive\" hoeveelheid=\"1\"></bestelling>";

			
			System.out.println(bestelling1);

			clientResource.post(bestelling1);

			String bestelling2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";

			bestelling2 += "<bestelling naamKlant =\"Jasper Maes3\" adres =\"Schensbossen 10\" datumBestelling =\"23/07/1994\" produktNaam =\"1 TB Harddrive\" hoeveelheid=\"1\"></bestelling>";

			clientResource.post(bestelling2);

			System.out.println(clientResource.getResponseEntity().getText());

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}