/**
 *
 * @author Corwin
 */

package org.greta.ppe.gsbview;

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

public class Login extends GSBView {

    private JPanel panel;
    private JButton btnOK;
    private JButton btnQuit;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField logTxt;
    private JTextField pwdTxt;

    /**
     * Creates new form identification
     */
    public Login() {
        initComponents();
    }

    /**
     * Main structure generated with netbeans
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        this.panel = new JPanel();
        logTxt = new JTextField();
        pwdTxt = new JTextField();
        btnOK = new JButton();
        btnQuit = new JButton();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setTitle("Swiss");
        this.frame.setForeground(Color.white);
        this.frame.setMinimumSize(new Dimension(800, 600));
        this.frame.setSize(new Dimension(800, 600));
        this.frame.getContentPane().setLayout(null);

        this.panel.setBackground(new Color(255, 255, 255));
        this.panel.setLayout(null);

        logTxt.setText("Login");
        logTxt.setMinimumSize(new Dimension(8, 20));
        logTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logTxtActionPerformed(evt);
            }
        });
        this.panel.add(logTxt);
        logTxt.setBounds(230, 180, 120, 20);

        pwdTxt.setText("Password");
        pwdTxt.setMinimumSize(new Dimension(8, 20));
        this.panel.add(pwdTxt);
        pwdTxt.setBounds(230, 210, 120, 20);

        btnOK.setText("Ok");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        this.panel.add(btnOK);
        btnOK.setBounds(370, 210, 50, 20);

        btnQuit.setText("Quitter");
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        this.panel.add(btnQuit);
        btnQuit.setBounds(670, 480, 73, 23);

        jLabel2.setFont(new Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new Color(153, 51, 255));
        jLabel2.setText("Identifiez vous");
        this.panel.add(jLabel2);
        jLabel2.setBounds(300, 130, 120, 20);

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/logoppe.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        this.panel.add(jLabel1);
        jLabel1.setBounds(0, 100, 790, 510);

        this.frame.getContentPane().add(this.panel);
        this.panel.setBounds(0, 0, 800, 600);
    }

    private void btnOKActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
    }

    private void logTxtActionPerformed(ActionEvent evt) {//GEN-FIRST:event_logTxtActionPerformed
        // TODO add your handling code here:
    }

    private void btnQuitActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
    System.exit(0);
    }

}
