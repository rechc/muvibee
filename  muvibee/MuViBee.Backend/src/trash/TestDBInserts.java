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
		Book b = new Book("null", "null", "null", "einBuch", "null", "null", 0, "null", "null", "null", "null", 0, "null", "null", null, false);
		Music m = new Music("null", "null", "null", "ichMusik", "null", "null", 0, "null", "null", "null", "null", 0, "null", "null", null, false);
		Video v = new Video("null", "null", "null", "DuVideo", "null", "null", 0, "null", "null", "null", "null", 0, "null", "null", null, false);
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
		m.insertIntoDB();
		
		v.setCover(bi3);
		v.setBackDate("2010-10-10");
		v.setLendDate("2010-10-10");
		v.insertIntoDB();	
		
		
//		try {
//			Connection con = null;
//			con = DBConnector.getConnection();
//			String insert_sql = "INSERT INTO books (title) VALUES ('ichbineinBuch')";
//			Statement st = con.createStatement();
//			st.execute(insert_sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		DBSelector dbs = new DBSelector("books", false);
		LinkedList<Media> mediaList;
		mediaList = dbs.getMediaList();
		for (Media m1 : mediaList) {
			m1.toString();
		}
	}
}