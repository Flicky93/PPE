/**
 * Control interface
 * @author Renaud Tripathi
 *
 * functional interface
 * Embed the control method declaration
 */

package org.greta.ppe.gsbutils;


public interface Control {
	/**
	 * Perform control over gui data and or the model return value.
	 * @return The next input to the FSM.
	 */
	public Input control();
}
