package de.muvibee.ean;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import de.muvibee.media.Book;
import de.muvibee.media.Music;
import de.muvibee.media.Video;

public class EAN {

	ResourceBundle bundle = ResourceBundle.getBundle("MuViBee");
	
	private long ean;
	private InputStream inputStream;
	
	public EAN() { }
	
	public void searchEan(String inData) {
		ean = checkEan(inData);
		try {
			inputStream = request(ean);
			checkRequest(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private long checkEan(String inData){
        long result = -1;
        inData = inData.replaceAll("-", "");
        try {
        	result = Long.parseLong(inData);
        } catch (NumberFormatException fehler) {
            System.out.println(bundle.getString("FALSE_EAN_FORMAT"));
            return -1;
        }
        return result;
    }
	
	public InputStream request(long ean) throws IOException {
		URL url = new URL("http://free.apisigning.com/onca/xml"
				+ "?Service=AWSECommerceService"
				+ "&AWSAccessKeyId=AKIAJX2W3VC3FH2N6J7A"
				+ "&Operation=ItemLookup"
				+ "&ItemId=" + ean
				+ "&ResponseGroup=ItemAttributes,Images" 
				+ "&SearchIndex=Blended"
				+ "&IdType=EAN");
		System.out.println(url);
		URLConnection conn = url.openConnection();
		conn.connect();
		return conn.getInputStream();
	}
	
	private void checkRequest(InputStream inputStream) throws XMLStreamException, FactoryConfigurationError, MalformedURLException {
		String error = null;
		String title = null;
		String publisher = null;
		String artist = null;
		String author = null;
		String isbn = null;
		String language = null;
		String productGroup = null;
		String numberOfPagesOrDisc = null;
		String theatricalReleaseDate = null;
		String ean = null;
		BufferedImage cover = null;
		
		XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance()
				.createXMLStreamReader(inputStream);
		
		int i = 1;
		int event = 0;
		while (xmlStreamReader.hasNext()) {
			event = xmlStreamReader.next();
        	if (event == XMLStreamConstants.START_ELEMENT) {
				if (xmlStreamReader.getLocalName().equals("Message")) {
					error = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("Title")) {
					title = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("Publisher")) {
					publisher = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("Artist")) {
					artist = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("Author")) {
					author = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("ISBN")) {
					isbn = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("Name")) {
					language = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("ProductGroup")) {
					productGroup = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("NumberOfPages")) {
					numberOfPagesOrDisc = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("NumberOfDiscs")) {
					numberOfPagesOrDisc = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("TheatricalReleaseDate")) {
					theatricalReleaseDate = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("PublicationDate")) {
					theatricalReleaseDate = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("ReleaseDate")) {
					theatricalReleaseDate = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("EAN")) {
					ean = xmlStreamReader.getElementText();
				}
				if (xmlStreamReader.getLocalName().equals("URL")) {
					if (i == 2) {
						String urlCover = xmlStreamReader.getElementText();
						URL url_cover = new URL(urlCover);
						try {
							cover = ImageIO.read(url_cover);
						} catch (IOException e) {
							e.printStackTrace();
						}
						i++;
					} else { 
						i++;
					}
				}
			}
		} 
		xmlStreamReader.close();
		if (error == null) {
			if (productGroup.equals("DVD") || productGroup.equals("Video")) {
				Video v = new Video("format", "director", "actor", title, ean, "genre", 2010, "location", "lendTo", "1999-01-01", "1999-05-05", 5, 
						"description", "comment", cover, false);
				v.insertIntoDB();
				System.out.println(bundle.getString("EAN_FOUND"));
			} else if (productGroup.equals("Music")) {
				Music m = new Music("format", "interpreter", "type", title, ean, "genre", 1996, "location", "lendTo", "2000-02-02", "2001-01-01", 3, 
						"description", "comment", cover, false);
				m.insertIntoDB();
				System.out.println(bundle.getString("EAN_FOUND"));
			} else if (productGroup.equals("Book")) {
				//Buch muss mit Konstruktor aufgerufen werden
				Book b = new Book(author, language, isbn, title, ean, "genre", 1999, "location", "lendTo", "2010-10-10", "2010-11-11", 12, 
						"description", "comment", cover, false);
				// Diese Klasse muss Buch/Musik/Video Objekt zurueckgeben
				b.insertIntoDB();
				System.out.println(bundle.getString("EAN_FOUND"));
			} else {
				System.out.println(bundle.getString("FALSE_EAN_MEDIA"));
			}
		} else {
			System.out.println(bundle.getString("FALSE_EAN"));
		}
	}
}
