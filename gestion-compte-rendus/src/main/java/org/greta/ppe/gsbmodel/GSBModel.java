/**
 * GSBModel Class
 * @author Renaud Tripathi
 *
 * Abstract application model.
 */

package org.greta.ppe.gsbmodel;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public abstract class GSBModel {

	protected static final String DRIVER = "com.mysql.jdbc.Driver";
	protected static final String URL = "jdbc:mysql://localhost/ppe";

	protected static final String LOG = "root";
	protected static final String PWD = "kaspov";

	protected Connection conn = null;
	protected Statement stmt = null;

	public GSBModel() { // singleton or not singleton ?
		try{
			Class.forName(GSBModel.DRIVER);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Connection initialiazation
	 * @throws SQLException If connection fails.
	 * */
	public void connect() throws SQLException {
		this.conn = DriverManager.getConnection(
			GSBModel.URL,GSBModel.LOG,GSBModel.PWD);
	}

	/**
	 * getter
	 * for tests only
	 */
	public Connection get_conn() {
		return this.conn;
	}
}
