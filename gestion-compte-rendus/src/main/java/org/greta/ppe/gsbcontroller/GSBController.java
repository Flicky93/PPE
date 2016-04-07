/**
 * GSBController class
 * @author Renaud Tripathi
 * 
 * Abstract application controller base class.
 * */

package org.greta.ppe.gsbcontroller;

import java.util.Observer;

import org.greta.ppe.gsbmodel.GSBModel;
import org.greta.ppe.gsbview.GSBView;

public abstract class GSBController <M extends GSBModel, V extends GSBView> implements Observer {
	
	protected M m;
	protected V v;

	public GSBController(M model, V view) {
		this.m = model;
		this.v = view;
	}
	// test only
	public M model() {
		return this.m;
	}
	public V view() {
		return this.v;
	}

	/**
	 * Biaise call toJFrame.setvisible(true)
	 * public for test only. Need to be protected
	 */
	public void display_view() {
		this.v.show();
	}

	protected Boolean test = false;
	/**
	 * for test only
	 * If the method id called, it means
	 * a notification for forwarding has 
	 * been received.
	 */
	public Boolean test() {
		return this.test;
	}
}
