/**
 * Gui test
 * @author Renaud Tripathi
 */

import java.util.Collection;
import java.util.Arrays;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.ButtonModel;
import java.awt.Component;

import org.greta.ppe.gsbview.GSBLoginBeta;

@RunWith(Parameterized.class)
public class GUITemplateTest {

	private String name;

	private static GSBLoginBeta gui;

	@BeforeClass
	public static void initialze() {
		GUITemplateTest.gui = new GSBLoginBeta();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList( new Object[][] {
			{"target"},{"decoy"}
		});
	}

	public GUITemplateTest(String name) {
		this.name = name;
	}

	@Test
	/**
	 * INternal test GUITestUtil
	 */
	public void response_test() {
		JRadioButton c = (JRadioButton)
			GUITestUtil.component_by_name(
				gui.getFrame(), 
				this.name);
		assertNotNull(c);
		c.setSelected(true);
		assertTrue(c.isSelected());
	}
}
