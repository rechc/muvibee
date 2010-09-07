package de.muvibee.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTest {
	final static String SQL0 = "CREATE TABLE test (spalte INT NOT NULL)";
	final static String SQL1 = "CREATE TABLE infos (ID INT NOT NULL IDENTITY, mediaID INT DEFAULT NULL, k_infoID INT DEFAULT NULL, value LONGVARCHAR)";
	final static String SQL2 = "CREATE TABLE k_format (ID INT NOT NULL IDENTITY, mediaID INT, stxt  varchar(255) DEFAULT NULL, ltxt LONGVARCHAR)";
	final static String SQL3 = "CREATE TABLE IF NOT EXISTS `k_genre` (`ID` int(10) NOT NULL AUTO_INCREMENT,`stxt` varchar(255) COLLATE latin1_german2_ci DEFAULT NULL,`ltxt` text COLLATE latin1_german2_ci,PRIMARY KEY (`ID`)) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci AUTO_INCREMENT=1";
	final static String SQL4 = "CREATE TABLE IF NOT EXISTS `k_infos` (`ID` int(10) NOT NULL AUTO_INCREMENT,`infosID` int(10) DEFAULT NULL,`name` varchar(45) COLLATE latin1_german2_ci DEFAULT NULL,PRIMARY KEY (`ID`)) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci AUTO_INCREMENT=1";
	final static String SQL5 = "CREATE TABLE lend (ID INT IDENTITY, mediaID INT NULL,lendDate date NULL,backDate date NULL,lendTo VARCHAR(255) NULL)";
	final static String SQL6 = "CREATE TABLE media (ID int IDENTITY, infosID INT NOT NULL, k_genreID INT NULL, lendID INT NULL, k_formatID INT NULL, title VARCHAR(255) NOT NULL,description LONGVARCHAR(1023), cover VARCHAR(255) NULL, rating INT NULL, comment VARCHAR(255) NULL, location VARCHAR(255) NULL, ean INT NULL, year INT NULL, genreID INT NULL, isDeleted BOOLEAN NOT NULL)";

	public static void main(String[] args) {
		try {
			System.out.println("11");
			PreparedStatement ps1 = DBConnector.getConnection().prepareStatement(SQL1);
			System.out.println("22");
//			PreparedStatement ps2 = DBConnector.getConnection().prepareStatement(SQL2);
//			PreparedStatement ps3 = DBConnector.getConnection().prepareStatement(SQL3);
//			PreparedStatement ps4 = DBConnector.getConnection().prepareStatement(SQL4);
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
