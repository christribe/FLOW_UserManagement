package com.cct.jdbc.ddl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLQueries implements DbQueryConstants {

	public SQLQueries() {
		super();

	}

	// JDBC Driver Name & Database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String JDBC_DB_URL = "jdbc:postgresql://baasu.db.elephantsql.com:5432/vkgtkyml?tcpKeepAlive=true";

	// JDBC Database Credentials
	static final String JDBC_USER = "vkgtkyml";
	static final String JDBC_PASS = "CJQAK2CUTPBxsAY-OBfu8DetlBkBHFNj";

	private Connection conn;

	public static void main(String[] args) {

		SQLQueries query = new SQLQueries();

		try {
			//query.selectAll();
			//query.deleteALL();
			query.selectAll();
			
			if (query.getConn() != null) {
				query.getConn().close();
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteALL() throws Exception {
		String query = "DELETE FROM tasks where taskname = null";

		PreparedStatement preparedStatement = getConn().prepareStatement(query);
		
		// execute delete SQL stetement
		preparedStatement.executeUpdate();
		
		
		if (preparedStatement != null) {
			preparedStatement.close();
		}



		System.out.println("Record is deleted!");
		
		
	}

	private void selectAll() throws Exception {
		// TODO Auto-generated method stub

		// create our mysql database connection

		// our SQL SELECT query.
		// if you only need a few columns, specify them by name instead of using "*"
		String query = "SELECT * FROM tasks";

		// create the java statement
		Statement st = getConn().createStatement();

		// execute the query, and get a java resultset
		ResultSet rs = st.executeQuery(query);

		// iterate through the java resultset
		while (rs.next()) {
			String id = rs.getString("taskid");

			String flowJoinURL = rs.getString("flowJoinURL");

			String taskName = rs.getString("taskName");
			/*
			 * String lastName = rs.getString("last_name"); Date dateCreated =
			 * rs.getDate("date_created"); boolean isAdmin = rs.getBoolean("is_admin"); int
			 * numPoints = rs.getInt("num_points");
			 */
			// print the results
			System.out.format("%s, %s, %s\n", id, taskName, flowJoinURL);
		}
		st.close();

	}

	public Connection getConn() {

		if (null == conn) {

			try {
				Class.forName(JDBC_DRIVER);
				this.conn = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASS);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return this.conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
