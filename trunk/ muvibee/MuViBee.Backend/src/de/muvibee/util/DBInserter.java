package de.muvibee.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;

import de.muvibee.database.DBConnector;
import de.muvibee.media.Book;

public class DBInserter {
	
	public final String BOOKSQL 	= "INSERT INTO books (ID, title, ean, genre, year, location, lendto, lenddate, backdate, rating, description, comment, cover, author, language, isbn, isdeleted) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public final String MUSICSQL 	= "INSERT INTO books (ID, title, ean, genre, year, location, lendto, lenddate, backdate, rating, description, comment, cover, format, interpreter, type, isdeleted) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public final String VIDEOSQL 	= "INSERT INTO books (ID, title, ean, genre, year, location, lendto, lenddate, backdate, rating, description, comment, cover, format, director, actor, isdeleted) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private Connection con = null;
	
	public DBInserter() {
//		try {
//			con = DBConnector.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	

	public int insertBook(Book b) {
		imageWriteToFile(b.getCover());
//		try {
//			PreparedStatement ps = con.prepareStatement(BOOKSQL);
//			ps.setString(1, b.getTitle());
//			ps.setString(2, b.getEan());
//			ps.setString(3, b.getGenre());
//			ps.setInt(4, b.getYear());
//			ps.setString(5, b.getLocation());
//			ps.setString(6, b.getLendTo());
//			ps.setString(7, b.getLendDate());
//			ps.setString(8, b.getBackDate());
//			ps.setInt(9, b.getRating());
//			ps.setString(10, b.getDescription());
//			ps.setString(11, b.getComment());
//			//ps.setString(12, b.getCover());
//			ps.setString(13, b.getAuthor());
//			ps.setString(14, b.getLanguage());
//			ps.setString(15, b.getIsbn());
//			ps.setBoolean(16, b.isDeleted());
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		//
		return 0;
	}
	
	private String imageWriteToFile(BufferedImage i)  {
		String pfad = "data/images/" + i.hashCode() + ".jpg";
		File f = new File(pfad);
        try {
			ImageIO.write(i, "jpg", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return pfad;
    }
}
