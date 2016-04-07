/**
 * Observer/Obervable local tests
 * @author Renaud Tripathi
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

import javax.swing.JTextField;

import org.junit.Test;
import org.junit.BeforeClass;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.notNullValue;


public class ObserverLocalTest {
	
	private static GUILocalTestUtil gui;
	private static ObserverLocalTestUtil obs;
	private String name;
	private String input;

	@BeforeClass
	public static void initialize() {
		ObserverLocalTest.gui = new GUILocalTestUtil();
		ObserverLocalTest.obs = new ObserverLocalTestUtil();
		ObserverLocalTest.gui.addObserver(ObserverLocalTest.obs);
	}

	public ObserverLocalTest() {
	}

	/**
	 * Test nested argument passing from Observable
	 * to Observer over notification.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void nested_argument_test() {
		JTextField t = (JTextField)GUITestUtil.component_by_name(
			ObserverLocalTest.gui.getFrame(),
			"lblTest1");
		assertThat(
			"JtextField lblTest1 no found",
			t,
			notNullValue());

		t.postActionEvent(); // trigger notification

		HashMap<String,String> h = (HashMap<String,String>)ObserverLocalTest.obs.get_control_value();
		assertThat(
			"No value retreived",
			h,
			notNullValue());
		assertThat(
			"HasMap Expected",
			h instanceof HashMap,
			is(true));

	}

	/**
	 * Test nested compound argument passing from Observable
	 * to Observer over notification.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void nested_compoud_argument_test() {
		JTextField t = (JTextField)GUITestUtil.component_by_name(
			ObserverLocalTest.gui.getFrame(),
			"lblTest2");
		assertThat(
			"JtextField lblTest2 no found",
			t,
			notNullValue());

		t.postActionEvent(); // trigger notification

		ArrayList<HashMap<String,String>> a = (ArrayList<HashMap<String,String>>)ObserverLocalTest.obs.get_control_value();
		assertThat(
			"No value retreived",
			a,
			notNullValue());
		assertThat(
			"HasMap Expected",
			a instanceof ArrayList,
			is(true));

	}
}
