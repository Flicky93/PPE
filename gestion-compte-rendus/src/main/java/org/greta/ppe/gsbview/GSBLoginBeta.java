/**
 * Gui beta class for testing
 * @author Renaud Tripathi
 */

package org.greta.ppe.gsbview;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GSBLoginBeta extends GSBView {

	private JPanel panel;
	private JRadioButton radio, decoy;
	private ButtonGroup group;
	private JTextField lblTest1, lblTest2;
	public  String s1, s2, s3;

	public GSBLoginBeta() {
		super();
		this.panel = new JPanel();
		this.panel.setName("GSB panel");

		this.radio = new JRadioButton("target");
		this.radio.setName("target");
		this.decoy = new JRadioButton("decoy");
		this.decoy.setName("decoy");

		this.group = new ButtonGroup();
		this.group.add(this.radio);
		this.panel.add(this.radio);
		this.group.add(this.decoy);
		this.panel.add(this.decoy);

		this.lblTest1 = new JTextField();
		this.lblTest1.setName("lblTest1");
		this.lblTest1.setActionCommand("lblTest1");
		this.lblTest2 = new JTextField();
		this.lblTest2.setName("lblTest2");
		this.lblTest2.setActionCommand("lblTest2");
		this.panel.add(this.lblTest1);
		this.panel.add(this.lblTest2);

		this.frame.add(this.panel);
		this.frame.pack();
		this.frame.setVisible(true);

		this.lblTest1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionLblTest(e.getActionCommand());
			}
		});
		this.lblTest2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionLblTest(e.getActionCommand());
			}
		});
	}

	private void actionLblTest(String s) {
		this.setChanged();
		String pack = (s == "lblTest1")? 
			GSBLoginBeta.this.lblTest1.getText() : 
				GSBLoginBeta.this.lblTest2.getText();
		this.notifyObservers(pack);
	}
}
