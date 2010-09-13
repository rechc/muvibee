package de.muvibee.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import de.muvibee.database.DBConnector;
import de.muvibee.media.Book;
import de.muvibee.media.Media;
import de.muvibee.media.Music;
import de.muvibee.media.Video;

/**
 * @author tobiaslana
 * 
 * Klasse erwartet beim Aufruf zwei Parameter
 * String media ['book' | 'music' | 'video'] dient zur Unterscheidung welche Daten selektiert werden sollen
 * Boolean deleted steuert ob geloeschte Daten selektiert werden oder nicht
 * 
 * mit getMediaList erhaelt man eine LinkedList<Media>
 * 
 * Aufruf:
 * DBSelector dbs = new DBSelector();
 * LinkedList<Media> mediaList;
 * mediaList = new dbs.getMediaList();
 *
 */

public class DBSelector {
	private final static String SQL_GET_BOOKS  	= "SELECT * FROM books WHERE isdeleted = ?";
	private final static String SQL_GET_MUSIC  	= "SELECT * FROM music WHERE isdeleted = ?";
	private final static String SQL_GET_VIDEOS  = "SELECT * FROM video WHERE isdeleted = ?";

	private static Connection con = null;
	
	private static LinkedList<Media> mediaList;
	
	public DBSelector(String media, Boolean deleted) {
		selectMedia(media, deleted);
	}
	
	public void selectMedia(String media, Boolean deleted) {
		try {
			con = DBConnector.getConnection();
			PreparedStatement ps = null;
			if (media.compareTo("book") == 0) {
				ps = con.prepareStatement(SQL_GET_BOOKS);
			}
			else if (media.compareTo("music") == 0) {
				ps = con.prepareStatement(SQL_GET_MUSIC);
			}
			else if (media.compareTo("video") == 0) {
				ps = con.prepareStatement(SQL_GET_VIDEOS);
			}
			ps.setBoolean(1, deleted);
			ResultSet rs = ps.executeQuery();
			RsToList(media, rs);
			con.prepareStatement("SHUTDOWN").execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void RsToList(String media, ResultSet rs) throws SQLException, IOException {
		mediaList = new LinkedList<Media>();
		while (rs.next()) {
			int ID 				= rs.getInt(1);
			String title 		= rs.getString(2);
			String ean 			= rs.getString(3);
			String genre 		= rs.getString(4);
			int year 			= rs.getInt(5);
			String location 	= rs.getString(6);
			String lendTo 		= rs.getString(7);
			String lendDate 	= rs.getString(8);
			String backDate 	= rs.getString(9);
			int rating	 		= rs.getInt(10);
			String description 	= rs.getString(11);
			String comment 		= rs.getString(12);
			String imagepath 	= rs.getString(13);
			BufferedImage cover = ImageIO.read(new File("resources/icons/" + imagepath));
			Boolean isDeleted 	= rs.getBoolean(17);
			if (media.compareTo("book") == 0) {
				String author 	= rs.getString(14);
				String language = rs.getString(15);
				String isbn 	= rs.getString(16);
				Book b = new Book(author, language, isbn, title, ean, genre, year, location, lendTo, lendDate, backDate, rating, description, comment, cover, isDeleted);
				mediaList.add(b);
			}
			else if (media.compareTo("music") == 0) {
				String format 		= rs.getString(14);
				String interpreter 	= rs.getString(15);
				String type			= rs.getString(16);	
				Music m = new Music(format, interpreter, type, title, ean, genre, year, location, lendTo, lendDate, backDate, rating, description, comment, cover, isDeleted);
				mediaList.add(m);
			}
			else if (media.compareTo("video") == 0) {
				String format 	= rs.getString(14);
				String director = rs.getString(15);
				String actor 	= rs.getString(16);	
				Video v = new Video(format, director, actor, title, ean, genre, year, location, lendTo, lendDate, backDate, rating, description, comment, cover, isDeleted);
				mediaList.add(v);
			}
			
		}
	}

	public static LinkedList<Media> getMediaList() {
		return mediaList;
	}

	public static void setMediaList(LinkedList<Media> mediaList) {
		DBSelector.mediaList = mediaList;
	}


}
