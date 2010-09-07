package de.muvibee.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBTest {
	final static String SQL0 = "CREATE TABLE test (spalte INT NOT NULL)";
	final static String SQL1 = "CREATE TABLE infos (ID INT NOT NULL IDENTITY, mediaID INT DEFAULT NULL, k_infoID INT DEFAULT NULL, value LONGVARCHAR)";
	final static String SQL2 = "CREATE TABLE k_format (ID INT NOT NULL IDENTITY, mediaID INT, stxt  varchar(255) DEFAULT NULL, ltxt LONGVARCHAR)";
	final static String SQL3 = "CREATE TABLE IF NOT EXISTS `k_genre` (`ID` int(10) NOT NULL AUTO_INCREMENT,`stxt` varchar(255) COLLATE latin1_german2_ci DEFAULT NULL,`ltxt` text COLLATE latin1_german2_ci,PRIMARY KEY (`ID`)) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci AUTO_INCREMENT=1";
	final static String SQL4 = "CREATE TABLE IF NOT EXISTS `k_infos` (`ID` int(10) NOT NULL AUTO_INCREMENT,`infosID` int(10) DEFAULT NULL,`name` varchar(45) COLLATE latin1_german2_ci DEFAULT NULL,PRIMARY KEY (`ID`)) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci AUTO_INCREMENT=1";
	final static String SQL5 = "CREATE TABLE IF NOT EXISTS `lend` (`ID` int(10) NOT NULL AUTO_INCREMENT,`mediaID` int(10) DEFAULT NULL,`lendDate` date DEFAULT NULL,`backDate` date DEFAULT NULL,`lendTo` varchar(255) COLLATE latin1_german2_ci DEFAULT NULL,PRIMARY KEY (`ID`)) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci AUTO_INCREMENT=1";
	final static String SQL6 = "CREATE TABLE IF NOT EXISTS `media` (`ID` int(10) NOT NULL AUTO_INCREMENT,`infosID` int(10) DEFAULT NULL,`k_genreID` int(10) DEFAULT NULL,`lendID` int(10) DEFAULT NULL,`k_formatID` int(10) DEFAULT NULL,`title` varchar(255) COLLATE latin1_german2_ci DEFAULT NULL,`description` text COLLATE latin1_german2_ci,`cover` varchar(255) COLLATE latin1_german2_ci DEFAULT NULL,`rating` int(10) DEFAULT NULL,`comment` varchar(255) COLLATE latin1_german2_ci DEFAULT NULL,`location` varchar(255) COLLATE latin1_german2_ci DEFAULT NULL,`EAN` int(10) DEFAULT NULL,`year` int(10) DEFAULT NULL,`genreID` int(10) DEFAULT NULL,`isDeleted` tinyint(1) NOT NULL,PRIMARY KEY (`ID`)) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_german2_ci AUTO_INCREMENT=1";
	
	public static void main(String[] args) {
		try {
			System.out.println("11");
			PreparedStatement ps1 = DBConnector.getConnection().prepareStatement(SQL1);
			System.out.println("22");
//			PreparedStatement ps2 = DBConnector.getConnection().prepareStatement(SQL2);
//			PreparedStatement ps3 = DBConnector.getConnection().prepareStatement(SQL3);
//			PreparedStatement ps4 = DBConnector.getConnection().prepareStatement(SQL4);
//			PreparedStatement ps5 = DBConnector.getConnection().prepareStatement(SQL5);
//			PreparedStatement ps6 = DBConnector.getConnection().prepareStatement(SQL6);
			
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
//			ps5.executeUpdate();
//			System.out.println("5");
//			
//			ps6.executeUpdate();
//			System.out.println("6");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
