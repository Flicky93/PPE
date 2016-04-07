/** 
 * Main file
 * @author Renaud Tripathi
 **/

package org.greta.ppe.gsbmain;

import org.greta.ppe.gsbcontroller.FSM;

/**
 * Main class
 * Runs the finite state machine until rejection.
 */
public class GSBMain {
	public static void main(String args[]){
		FSM gsb = new FSM();
		
		// main loop
	 	while(gsb.alive()){
	 		gsb.live();
	 	}
	}
}
