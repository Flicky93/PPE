/**
 * NullView pattern class
 * @author Renaud Tripathi
 */

package org.greta.ppe.gsbview;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NullView extends GSBView {
	
	// minimum component set
	private JButton btnOk;
	private JPanel panel;

	public NullView() {
		super();
		this.initComponents();
	}

	private void initComponents() {
		
		this.panel = new JPanel();
		this.btnOk = new JButton();
		this.btnOk.setName("btnOk");

		this.btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                		btnOkActionPerformed(e);
			}
		});
		this.panel.add(this.btnOk);
		this.frame.add(this.panel);
		this.frame.pack();
	}

	/**
	 * NotifyObservers needsto be call at least once
	 */
	private void btnOkActionPerformed(ActionEvent e) {
		this.setChanged();
		// for test only
		this.notifyObservers(null);
	}
}
