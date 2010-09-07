package de.muvibee.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTest {
	final static String SQL1 = "CREATE TABLE infos (ID INT NOT NULL IDENTITY, mediaID INT DEFAULT NULL, k_infoID INT DEFAULT NULL, value LONGVARCHAR)";
	final static String SQL2 = "CREATE TABLE k_format (ID INT NOT NULL IDENTITY, mediaID INT DEFAULT NULL, stxt  VARCHAR(255) DEFAULT NULL, ltxt LONGVARCHAR)";
	final static String SQL3 = "CREATE TABLE k_genre (ID INT NOT NULL IDENTITY, stxt VARCHAR(255) NOT NULL, ltxt LONGVARCHAR)";
	final static String SQL4 = "CREATE TABLE k_infos (ID INT NOT NULL IDENTITY, infosID INT DEFAULT NULL, name VARCHAR(255) DEFAULT NULL)";
	final static String SQL5 = "CREATE TABLE lend (ID INT IDENTITY, mediaID INT DEFAULT NULL,lendDate date DEFAULT NULL,backDate date DEFAULT NULL,lendTo VARCHAR(255) DEFAULT NULL)";
	final static String SQL6 = "CREATE CACHED TABLE media (ID INT IDENTITY, infosID INT NOT NULL, k_genreID INT DEFAULT NULL, lendID INT DEFAULT NULL, k_formatID INT DEFAULT NULL, title VARCHAR(255) NOT NULL,description LONGVARCHAR, cover VARCHAR(255) DEFAULT NULL, rating INT DEFAULT NULL, comment VARCHAR(255) DEFAULT NULL, location VARCHAR(255) DEFAULT NULL, ean INT DEFAULT NULL, year INT DEFAULT NULL, genreID INT DEFAULT NULL, isDeleted BOOLEAN NOT NULL)";

	public static void main(String[] args) {
		try {
			Connection con = DBConnector.getConnection();
			PreparedStatement ps1 = con.prepareStatement(SQL1);
			PreparedStatement ps2 = con.prepareStatement(SQL2);
			PreparedStatement ps3 = con.prepareStatement(SQL3);
			PreparedStatement ps4 = con.prepareStatement(SQL4);
			PreparedStatement ps5 = con.prepareStatement(SQL5);
			PreparedStatement ps6 = con.prepareStatement(SQL6);

			ps1.executeUpdate();
			ps2.executeUpdate();
			ps3.executeUpdate();
			ps4.executeUpdate();
			ps5.executeUpdate();
			ps6.executeUpdate();

			con.prepareStatement("SHUTDOWN").execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
