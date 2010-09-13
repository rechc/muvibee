package de.muvibee.ean;

import java.util.Locale;



public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Locale turkish = new Locale("tr", "TR");
//		Locale russian = new Locale("ru", "RU");
		//Kann man die Sprache setzen, wenn nicht wird die Systemsprache verwendet
		//Locale.setDefault(russian);
		EAN ean = new EAN();
		//Illuminati Buch EAN
		ean.searchEan("9783404148660");
		System.out.println("-------------");
		//Schindlers Liste Buch
		ean.searchEan("9783570300046");
		System.out.println("-------------");
		// Schindlers Liste Movie
		ean.searchEan("5050582207804");
		System.out.println("-------------");
		// Beverly Hills Cop
		ean.searchEan("4010884538366");
		System.out.println("-------------");
		// Bravo Hits 65 CD
		ean.searchEan("0886974796626");
		System.out.println("-------------");
		// Hellboy DVD
		ean.searchEan("5050582594218");
		System.out.println("-------------");
	}
}