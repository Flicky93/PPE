/**
 * GUILocalBeta class
 * @author Renaud Tripathi
 *
 * Gui beta class for local testing
 */

import java.util.ArrayList;
import java.util.HashMap;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.greta.ppe.gsbview.GSBView;

public class GUILocalTestUtil extends GSBView {

	private JPanel panel;
	private JTextField lblTest1, lblTest2;

	public GUILocalTestUtil() {
		super();
		this.panel = new JPanel();
		this.panel.setName("GSB panel");

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
				actionNestedObject();
			}
		});
		this.lblTest2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCompoundObject();
			}
		});
	}

	/**
	 * Simple data type argument for gsb application
	 * HashMap<String,String> h
	 */
	private void actionNestedObject() {
		this.setChanged();
		HashMap<String,String> h = new HashMap<String,String>() {{
			put("key1","value1"); 
			put("key2","value2");
		}};
		this.notifyObservers(h);
	}

	/**
	 * Compound data type argument for gsb application
	 * ArrayList<HashMap<String,String>>
	 */
	private void actionCompoundObject() {
		this.setChanged();
		ArrayList<HashMap<String,String>> c = new ArrayList<HashMap<String,String>>() {{
			add(new HashMap<String,String>() {{
				put("key1-1","value1-1");
				put("key1-2","value1-2");
			}});
			add(new HashMap<String,String>() {{
				put("key2-1","value2-11");
				put("key2-2","value2-2");
			}});
				
		}};
		this.notifyObservers(c);
	}
}
