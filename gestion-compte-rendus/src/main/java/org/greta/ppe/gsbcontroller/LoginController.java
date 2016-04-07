/**
 * LoginController class
 * @author Renaud Tripathi
 * 
 * All XXXController classes extends GSBController
 * All XXXController classes implements Control
 * Those classes embed all control, data forwarding and
 * data passing utilities.
 * @see GSBController
 * @see Control
 * */

package org.greta.ppe.gsbcontroller;

import java.util.HashMap;

import java.util.Observable;

import org.greta.ppe.gsbutils.Control;
import org.greta.ppe.gsbutils.Input;
import org.greta.ppe.gsbmodel.LoginModel;
import org.greta.ppe.gsbview.LoginView;

public class LoginController extends GSBController implements Control {
	
	private HashMap<String,String> data;

	@SuppressWarnings("unchecked")
	public LoginController() {
		// prepare data for super instantiation
		super(new LoginModel(), new LoginView());
	}
	
	@Override
	public Input control() {
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void update(Observable o, Object arg) {
		// data control call interface Control method
		// data transmission
		this.test = true;;
	}
}

