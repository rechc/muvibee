package trash;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import de.muvibee.database.DBConnector;
import de.muvibee.media.Media;
import de.muvibee.media.Book;
import de.muvibee.media.Music;
import de.muvibee.media.Video;
import de.muvibee.util.DBSelector;

public class TestDBInserts {

	public static void main(String[] args) {
		
		Book b = new Book(-1, "null", "null", "null", "einBuch23", "null", "null", 0, "null", "null", "null", "null", 0, "null", "null", null, false);
		Music m = new Music(-1, "null", "null", "null", "ichMusik23", "null", "null", 0, "null", "null", "null", "null", 0, "null", "null", null, false);
		Video v = new Video(-1, "null", "null", "null", "DuVideo23", "null", "null", 0, "null", "null", "null", "null", 0, "null", "null", null, false);
		BufferedImage bi1 = new BufferedImage(1, 2, 3);
		BufferedImage bi2 = new BufferedImage(4, 5, 6);
		BufferedImage bi3 = new BufferedImage(7, 8, 9);
		b.setCover(bi1);
		b.setBackDate("2010-10-10");
		b.setLendDate("2010-10-10");
		System.out.println(b.toString());
		b.insertIntoDB();

		m.setCover(bi2);
		m.setBackDate("2010-10-10");
		m.setLendDate("2010-10-10");
		System.out.println(m.toString());
		m.insertIntoDB();
		
		v.setCover(bi3);
		v.setBackDate("2010-10-10");
		v.setLendDate("2010-10-10");
		System.out.println(v.toString());
		v.insertIntoDB();	

		
		
	}
}