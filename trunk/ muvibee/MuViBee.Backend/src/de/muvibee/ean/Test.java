package de.muvibee.ean;

import java.util.Locale;



public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale turkish = new Locale("tr", "TR");
		Locale russian = new Locale("rug", "RU");
		//Kann man die Sprache setzen, wenn nicht wird die Systemsprache verwendet
		//Locale.setDefault(russian);
		EAN ean = new EAN();
		//Illuminati Buch EAN
		ean.searchEan("9783404148660");
	}
}