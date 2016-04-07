/**
 * State enum class
 * @author Renaud Tripathi
 *
 * Define status in gsb application stf
 * @see GSBSTF
 **/

package org.greta.ppe.gsbutils;

import org.greta.ppe.gsbcontroller.*; // full require

public enum State {
	INIT ("Login",LoginController.class), 
	Q1 ("Menu",MenuController.class), 
	Q2 ("Report",ReportController.class), 
	Q3 ("Visitor",VisitorController.class),
	Q4 ("Medic",MedicController.class), 
	Q5 ("Drug",DrugController.class), 
	Qz ("undefined",NullController.class), 
	FINAL("Final",NullController.class);

	private final String label;
	private Class<? extends GSBController> controllerClass;

	private <C extends GSBController> State(String label, Class<C> c) {
		this.label = label;
		this.controllerClass = c;
	}

	public String label() {
		return this.label;
	}

	/**
	 * Return true
	 * use to generate a nullPointerException when
	 * retreiving a null State from the stf.
	 */
	public boolean test() {
		return true;
	}

	/**
	 * return an instance of the controller related
	 * to the enum type.
	 */
	@SuppressWarnings("unchecked")
	public <C extends GSBController> C controller() {
		try {
			return (C)this.controllerClass.newInstance();
		}catch(InstantiationException | IllegalAccessException e) {
			return (C)new NullController();
		}
	}
}
