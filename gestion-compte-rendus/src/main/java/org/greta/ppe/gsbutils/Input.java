/**
 * File name : Input.java
 * @author Renaud Tripathi
 *
 * Define controller inputs
 **/

 package org.greta.ppe.gsbutils;

public enum Input {
	I0 ("Login"), I1 ("Menu"), I2 ("Report"), I3 ("Visitor"),
	I4 ("Doctor"), I5 ("Drug"), I6 ("Final"), Iz ("undefined");

	private final String nextViewName;

	private Input(String nextViewName) {
		this.nextViewName = nextViewName;
	}

	public String next_view_name() {
		return this.nextViewName;
	}
}
