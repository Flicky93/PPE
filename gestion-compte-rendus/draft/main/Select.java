/**
 * Select Class
 * @author Renaud Tripathi
 *
 * SQL select statement structure and methods
 */

package org.greta.ppe.gsbutils;

public class Select {
	
	private String table;
	private String stmt;

	public String table() {
		return this.table;
	}

	public void table(String tableStmt) {
		this.table = tableStmt;
	}

	// for test only
	public void reset() {
		this.stmt = "";
	}
}
