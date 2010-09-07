package de.muvibee.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Yassir Klos
 */
public class DBConnector {
	/**
	 * Erstellt eine Verbindung mit der internen HSQL Datenbank
	 * 
	 * @return Connection
	 * @throws SQLException
	 * @throws MySQLException
	 */
	public static Connection getConnection() throws SQLException {
        try {
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:hsqldb:file:./data/database", "SA", "");
	}
}