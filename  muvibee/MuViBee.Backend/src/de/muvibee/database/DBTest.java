package de.muvibee.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTest {
	final static String SQL0 = "CREATE TABLE test (spalte INT NOT NULL)";
	final static String SQL1 = "CREATE TABLE infos (ID INT NOT NULL IDENTITY, mediaID INT DEFAULT NULL, k_infoID INT DEFAULT NULL, value LONGVARCHAR)";
	final static String SQL2 = "CREATE TABLE k_format (ID INT NOT NULL IDENTITY, mediaID INT DEFAULT NULL, stxt  VARCHAR(255) DEFAULT NULL, ltxt LONGVARCHAR)";
	final static String SQL3 = "CREATE TABLE k_genre (ID INT NOT NULL IDENTITY, stxt VARCHAR(255) NOT NULL, ltxt LONGVARCHAR)";
	final static String SQL4 = "CREATE TABLE k_infos (ID INT NOT NULL IDENTITY, infosID INT DEFAULT NULL, name VARCHAR(255) DEFAULT NULL)";
	final static String SQL5 = "CREATE TABLE lend (ID INT IDENTITY, mediaID INT DEFAULT NULL,lendDate date DEFAULT NULL,backDate date DEFAULT NULL,lendTo VARCHAR(255) DEFAULT NULL)";
	final static String SQL6 = "CREATE TABLE media (ID INT IDENTITY, infosID INT NOT NULL, k_genreID INT DEFAULT NULL, lendID INT DEFAULT NULL, k_formatID INT DEFAULT NULL, title VARCHAR(255) NOT NULL,description LONGVARCHAR(1023), cover VARCHAR(255) DEFAULT NULL, rating INT DEFAULT NULL, comment VARCHAR(255) DEFAULT NULL, location VARCHAR(255) DEFAULT NULL, ean INT DEFAULT NULL, year INT DEFAULT NULL, genreID INT DEFAULT NULL, isDeleted BOOLEAN NOT NULL)";

	public static void main(String[] args) {
		try {
			System.out.println("11");
			PreparedStatement ps1 = DBConnector.getConnection().prepareStatement(SQL1);
			System.out.println("22");
			PreparedStatement ps2 = DBConnector.getConnection().prepareStatement(SQL2);
			PreparedStatement ps3 = DBConnector.getConnection().prepareStatement(SQL3);
			PreparedStatement ps4 = DBConnector.getConnection().prepareStatement(SQL4);
			PreparedStatement ps5 = DBConnector.getConnection().prepareStatement(SQL5);
			PreparedStatement ps6 = DBConnector.getConnection().prepareStatement(SQL6);
			
			System.out.println("0");
			ps1.executeUpdate();
			System.out.println("1");
//			
//			ps2.executeUpdate();
//			System.out.println("2");
//			
//			ps3.executeUpdate();
//			System.out.println("3");
//			
//			ps4.executeUpdate();
//			System.out.println("4");
//			
			ps5.executeUpdate();
			System.out.println("5");
//			
			ps6.executeUpdate();
			System.out.println("6");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
