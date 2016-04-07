/**
 *
 * @author Corwin Ollier
 * @author Renaud Triapthi
 *
 * Identification window
 */

package org.greta.ppe.gsbview;

import java.util.HashMap;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends GSBView {

    private JPanel panel;
    private JButton btnOk;
    private JButton btnQuit;
    private JLabel icon;
    private JLabel idPrompt;
    private JTextField logTxt;
    private JTextField pwdTxt;

    /**
     * Creates new form identification
     */
    public LoginView() {
    	super();
	initComponents();
    }

    /**
     * Main structure generated with netbeans
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        this.panel = new JPanel();
	this.panel.setName("panelName");
	this.logTxt = new JTextField();
	this.pwdTxt = new JTextField();
	this.btnOk = new JButton();
	this.btnOk.setName("btnOk");
	this.btnQuit = new JButton();
	this.idPrompt = new JLabel();
	this.icon = new JLabel();

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setTitle("Swiss");
        this.frame.setForeground(Color.white);
        this.frame.setMinimumSize(new Dimension(800, 600));
        this.frame.setSize(new Dimension(800, 600));
        this.frame.getContentPane().setLayout(null);

        this.panel.setBackground(new Color(255, 255, 255));
        this.panel.setLayout(null);

        this.logTxt.setText("Login");
        this.logTxt.setMinimumSize(new Dimension(8, 20));
        this.logTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logTxtActionPerformed(evt);
            }
        });
        this.panel.add(logTxt);
        this.logTxt.setBounds(230, 180, 120, 20);

        this.pwdTxt.setText("Password");
        this.pwdTxt.setMinimumSize(new Dimension(8, 20));
        this.panel.add(pwdTxt);
        this.pwdTxt.setBounds(230, 210, 120, 20);

        this.btnOk.setText("Ok");
        this.btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        this.panel.add(this.btnOk);
        this.btnOk.setBounds(370, 210, 50, 20);

        this.btnQuit.setText("Quitter");
        this.btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        this.panel.add(btnQuit);
        this.btnQuit.setBounds(670, 480, 73, 23);

        this.idPrompt.setFont(new Font("Arial", 0, 18)); // NOI18N
        this.idPrompt.setForeground(new Color(153, 51, 255));
        this.idPrompt.setText("Identifiez vous");
        this.panel.add(idPrompt);
        this.idPrompt.setBounds(300, 130, 120, 20);

        this.icon.setIcon(new ImageIcon("ressources/logoppe.jpg")); // NOI18N
        this.icon.setToolTipText("");
        this.panel.add(icon);
        this.icon.setBounds(0, 100, 790, 510);

        this.panel.setBounds(0, 0, 800, 600);

        this.frame.add(this.panel);
	this.frame.pack();
    }

    private void btnOkActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
    	this.setChanged();
	HashMap arg = new HashMap<String,String>() {{
		put("log",LoginView.this.logTxt.getText());
		put("pwd",LoginView.this.pwdTxt.getText());
	}};
	this.notifyObservers(arg);
    }

    private void logTxtActionPerformed(ActionEvent evt) {//GEN-FIRST:event_logTxtActionPerformed
        // TODO add your handling code here:
    }

    private void btnQuitActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
    	System.exit(0);
    }

}
