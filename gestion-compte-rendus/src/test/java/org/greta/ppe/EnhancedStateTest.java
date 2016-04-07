/**
 * gsbutils.State properties test
 * @author Renaud Tripathi
 *
 * Test a second version of gsbutils.State
 * State is abble to return controller instances
 * accordingly to its internal valor.
 * <p>
 * A untested new version of STF is use. This new version
 * change only in its constructor argument which are those
 * used previously in the STFMatrixTest.
 * 
 * @see STFMatrixTest
 */

import java.util.Collection;
import java.util.Arrays;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;

import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.greta.ppe.gsbcontroller.GSBController;
import org.greta.ppe.gsbview.GSBView;
import org.greta.ppe.gsbmodel.GSBModel;
import org.greta.ppe.gsbutils.GSBSTF;
import org.greta.ppe.gsbutils.State;
import org.greta.ppe.gsbutils.Input;

@RunWith(Parameterized.class)
public class EnhancedStateTest {
	
	private static GSBSTF stf;
	private State state;
	private Input input;
	private String controller;
	private String model;
	private String view;

	@BeforeClass
	public static void initialize() {
		EnhancedStateTest.stf = new GSBSTF();
	}

	public EnhancedStateTest(State state, Input input, String name) {
		this.state = state;
		this.input = input;
		this.controller = name + "Controller";
		this.model = name + "Model";
		this.view = name + "View";
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{State.INIT,Input.I0,"Login"},
			{State.INIT,Input.I1,"Menu"},
			{State.Q1,Input.I2,"Report"},
			{State.Q1,Input.I3,"Visitor"},
			{State.Q1,Input.I4,"Medic"},
			{State.Q1,Input.I5,"Drug"},
			{State.Q2,Input.I1,"Menu"}
		});
	}

	/**
	 * Check stf State.controller() returns 
	 * through argument sequence.
	 */
	@Test
	public <C extends GSBController> void checks_controller_returns() 
							throws SQLException {
		State test = 
			EnhancedStateTest.stf.next_state(this.state,this.input);
		C c = test.controller();
		String name = c.getClass().getSimpleName();

		// is it the right controller ?
		assertThat(
			name + " == " + this.controller + " fails",
			name.equals(this.controller),
			is(true));

		// v and m instantiated ?
		assertThat(
			"No model instanciated for " + name,
			c.model(),
			notNullValue());
		assertThat(
			"No view instanciated for " + name,
			c.view(),
			notNullValue());

		// database connection test
		c.model().connect(); // connection attempt
		Connection conn = c.model().get_conn();
		assertThat(
			"No database connection for " + name,
			conn,
			notNullValue());

		// disconnection test
		conn.close();
		assertThat(
			"database cursor unreachable for " + name,
			conn.isClosed(),
			is(true));

	}

	/**
	 * Display test
	 */
	@Test
	@SuppressWarnings("unchecked")
	public <C extends GSBController> void display_view_test() 
						throws InterruptedException {
		State test = 
			EnhancedStateTest.stf.next_state(this.state,this.input);
		GUIThreadTestUtil<C> guiTest = 
			new GUIThreadTestUtil<C>((C)test.controller());
		assertThat(
			"Instance does not implements Runnable",
			guiTest instanceof Runnable,
			is(true));
		Thread thread = new Thread(guiTest);
		thread.start();
		Thread.sleep(2000);
		thread.interrupt();
	}

	/**
	 * Check stf State.model() returns 
	 * through argument sequence.
	 *
	@Test
	public <M extends GSBModel> void checks_model_returns() throws SQLException {
		State test = EnhancedStateTest.stf.next_state(this.state,this.input);
		M m = test.model();
		String name = m.getClass().getSimpleName();

		// Is it the right model ?
		assertThat(
			name + " == " + this.model + " fails",
			name.equals(this.model),
			is(true));

		// connection test
		m.connect();
		Connection conn = m.get_conn();
		assertThat(
			"No databse connection with " + name,
			conn,
			notNullValue());

		// close connection
		conn.close();
		assertThat(
			"Connection still up",
			conn.isClosed(),
			is(true));
	}
	 */
	 /**
	  * mvc coordination test
	 @Test
	 @SuppressWarnings("unchecked")
	 public <M extends GSBModel, V extends GSBView, C extends GSBController> void mvc_test() {
	 	State test = EnhancedStateTest.stf.next_state(this.state,this.input);
		M m  = test.model();
		V v = test.view();
		C c = test.controller();

		// add c to observers view 
		v.addObserver(c);
		assertThat(
			"No observer registered",
			v.countObservers(),
			is(1));

		JButton btn = (JButton)GUITestUtil.component_by_name(v.getFrame(),"btnOk");

		// An element has been retreived ?
		assertThat(
			"null element",
			btn,
			notNullValue());

		btn.doClick(); // trigger event
		// check for result 
		assertThat(
			"receiver fails in controller",
			c.test(),
			is(true));
	 }
	  */
}

