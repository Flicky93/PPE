/**
 * MenuView pattern class
 * @author Renaud Tripathi
 */

package org.greta.ppe.gsbview;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends GSBView {

	private JCheckBox crBox;
	private JCheckBox visitBox;
	private JCheckBox medicBox;
	private JCheckBox drugBox;
	private JCheckBox quitBox;
	private JPanel jPanelGsb;
	private JLabel jLabel1;
	private JPanel jPanelHaut;
	private JTextField jTextField1;
	
	public MenuView() {
		super();
		this.initComponents();
	}

	private void initComponents() {

		this.crBox = new JCheckBox();
		this.crBox.setActionCommand("Report");
		this.visitBox = new JCheckBox();
		this.visitBox.setActionCommand("Visitor");
		this.medicBox = new JCheckBox();
		this.medicBox.setActionCommand("Medic");
		this.drugBox = new JCheckBox();
		this.drugBox.setActionCommand("Drug");
		this.quitBox = new JCheckBox();
		this.quitBox.setActionCommand("Null");
		this.jPanelGsb = new JPanel();
		this.jLabel1 = new JLabel();
		this.jPanelHaut = new JPanel();
		this.jTextField1 = new JTextField();

		this.frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.frame.setTitle("Gestion des comptes-rendus");
		this.frame.setMinimumSize(new java.awt.Dimension(800, 600));
		this.frame.setPreferredSize(new java.awt.Dimension(800, 600));
		this.frame.setSize(new java.awt.Dimension(800, 600));
		this.frame.getContentPane().setLayout(null);

		this.crBox.setText("Comptes-Rendus");
		this.crBox.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
			ActionPerformed(evt);
		    }
		});
		this.frame.getContentPane().add(crBox);
		this.crBox.setBounds(340, 260, 130, 23);

		this.visitBox.setText("Visiteurs");
		this.visitBox.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
			ActionPerformed(evt);
		    }
		});
		this.frame.getContentPane().add(visitBox);
		this.visitBox.setBounds(340, 290, 130, 23);

		this.medicBox.setText("Praticiens");
		this.medicBox.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
			ActionPerformed(evt);
		    }
		});
		this.frame.getContentPane().add(medicBox);
		this.medicBox.setBounds(340, 320, 130, 23);

		this.drugBox.setText("Medicaments");
		this.drugBox.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
			ActionPerformed(evt);
		    }
		});
		this.frame.getContentPane().add(drugBox);
		this.drugBox.setBounds(340, 350, 130, 23);

		this.quitBox.setText("Quitter");
		this.quitBox.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
			ActionPerformed(evt);
		    }
		});
		this.frame.getContentPane().add(quitBox);
		this.quitBox.setBounds(340, 380, 130, 23);

		this.jPanelGsb.setBackground(new java.awt.Color(51, 102, 255));
		this.jPanelGsb.setLayout(null);

		this.jLabel1.setIcon(new ImageIcon("ressources/logotoutpetit.jpg"));
		this.jPanelGsb.add(jLabel1);
		this.jLabel1.setBounds(80, 170, 180, 150);

		this.frame.getContentPane().add(jPanelGsb);
		this.jPanelGsb.setBounds(0, 80, 330, 520);

		this.jPanelHaut.setBackground(new java.awt.Color(51, 102, 255));

		this.jTextField1.setBackground(new java.awt.Color(51, 102, 255));
		this.jTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
		this.jTextField1.setForeground(new java.awt.Color(255, 255, 255));
		this.jTextField1.setText("Gestion des comptes-rendus");
		this.jTextField1.setBorder(null);

		GroupLayout jPanelHautLayout = new GroupLayout(jPanelHaut);
		this.jPanelHaut.setLayout(jPanelHautLayout);
		jPanelHautLayout.setHorizontalGroup(
		    jPanelHautLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(GroupLayout.Alignment.TRAILING, jPanelHautLayout.createSequentialGroup()
			.addContainerGap(342, Short.MAX_VALUE)
			.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
			.addContainerGap())
		);
		jPanelHautLayout.setVerticalGroup(
		    jPanelHautLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(GroupLayout.Alignment.TRAILING, jPanelHautLayout.createSequentialGroup()
			.addGap(0, 33, Short.MAX_VALUE)
			.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
		);

		this.frame.getContentPane().add(jPanelHaut);
		this.jPanelHaut.setBounds(0, 0, 800, 80);

		this.frame.pack();
	}

	/**
	 * NotifyObservers needsto be call at least once
	 */
	private void btnOkActionPerformed(ActionEvent e) {
		this.setChanged();
		// for test only
		String arg = this.getClass().getSimpleName();
		this.notifyObservers(arg);
	}
			
	/**
	 * The sole actionCommand is needed thus we declare
	 * only one actionPerformed method
	 */
	private void ActionPerformed(ActionEvent evt) {
		this.setChanged();
		String arg = evt.getActionCommand();
		this.notifyObservers(arg);
	}
}
