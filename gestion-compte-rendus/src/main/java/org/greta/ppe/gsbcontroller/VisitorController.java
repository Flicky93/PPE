/**
 * VisitorController class
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
import org.greta.ppe.gsbmodel.VisitorModel;
import org.greta.ppe.gsbview.VisitorView;

public class VisitorController extends GSBController implements Control {
	

	@SuppressWarnings("unchecked")
	public VisitorController() {
		// prepare data for super instantiation
		super(new VisitorModel(), new VisitorView());
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

