/**
 * NullController class
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

import java.util.Observable;

import org.greta.ppe.gsbutils.Control;
import org.greta.ppe.gsbutils.Input;
import org.greta.ppe.gsbmodel.NullModel;
import org.greta.ppe.gsbview.NullView;

public class NullController extends GSBController implements Control {
	

	@SuppressWarnings("unchecked")
	public NullController() {
		// prepare data for super instantiation
		super(new NullModel(), new NullView());
	}

	@Override
	public Input control() {
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.test = true;
	}
}

