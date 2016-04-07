/**
 * Observer/Obervable tests
 * @author Renaud Tripathi
 */

import java.util.Arrays;
import java.util.Collection;

import javax.swing.JTextField;


import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Test;
import org.junit.BeforeClass;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.notNullValue;

import org.greta.ppe.gsbview.GSBLoginBeta;

@RunWith(Parameterized.class)
public class ObservableTest {
	
	private static GSBLoginBeta gui;
	private static ObserverTestUtil obs;
	private String name;
	private String input;

	@BeforeClass
	public static void initialize() {
		ObservableTest.gui = new GSBLoginBeta();
		ObservableTest.obs = new ObserverTestUtil();
		ObservableTest.gui.addObserver(ObservableTest.obs);
	}

	public ObservableTest(String name,String input) {
		this.name = name;
		this.input = input;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"lblTest1","str a"},{"lblTest2","str b"},
			{"lblTest1","str c"},{"lblTest2","str d"},
			{"lblTest1","str e"},{"lblTest2","str f"}
		});
	}

	/**
	 * Test argument passing from Observable
	 * to Observer over notification.
	 */
	@Test
	public void update_test() {
		// Observer is registered ?
		assertThat(
			"No observer registered",
			ObservableTest.gui.countObservers(),
			is(1));

		// Control value is unset ?
		assertThat(
			"Control value is set already",
			ObservableTest.obs.get_control_value(),
			nullValue());

		JTextField lbl = (JTextField)GUITestUtil.
			component_by_name(gui.getFrame(),this.name);

		// An element has been retreived
		assertThat(
			"null element. " + this.name + " needed",
			lbl,
			notNullValue());

		lbl.setText(this.input);
		lbl.postActionEvent(); // -> press enter
		
		// In pput has been setup ?
		assertThat(
			"No data send",
			lbl.getText(),
			is(this.input));

		// The control value has been set
		assertThat(
			"Control value fail",
			ObservableTest.obs.get_control_value(),
			is(this.input));

		// field reset
		lbl.setText("");
		lbl.postActionEvent(); // -> press enter
		// set the control value to null
		ObservableTest.obs.reset();
	}
}
