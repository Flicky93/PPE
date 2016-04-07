/**
* View's base class
* extends Observable
* @author Renaud Tripathi
**/

package org.greta.ppe.gsbview;

import java.util.Observable;

import javax.swing.JFrame;

public abstract class GSBView extends Observable {

	protected JFrame frame;

	public GSBView(){
		this.frame = new JFrame();
		this.frame.setName("GSB Main frame");
	}

	/**
	 * Window display command
	 * Must be call from controller
	 */
	public void show() {
		this.frame.setVisible(true);
	}

	/**
	 * window close command
	 * Must be call from controller
	 */
	public void close() {
		this.frame.dispose();
	}

	/**
	 * getter
	 * for tests only
	 */
	public JFrame getFrame() {
		return this.frame;
	}
}

