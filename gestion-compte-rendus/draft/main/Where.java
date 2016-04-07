/**
 * Where class
 * @author Renaud Tripathi
 *
 * Sub module for sql statement creation
 * @see Select
 */

package org.greta.ppe.gsbutils;

import java.util.ArrayList;

public class Where {
	
	private ArrayList clause;

	/**
	 * where clause insertion
	 * @param key the hash key or table field.
	 * @param value the value.
	 * @param op the operator.
	 */
	public void add(String key, String value, String op) {
		this.clause.add(new HashMap<String,String,String>() {{
			put(key,value);
		}});
	}

}
