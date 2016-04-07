/**
 * Test FSM methods based on reflection.
 * @author Renaud Tripathi
 * @see FSM
 */

import java.util.Collection;
import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.greta.ppe.gsbcontroller.FSM;
import org.greta.ppe.gsbview.GSBLoginBeta;

@RunWith(Parameterized.class)
public class FSMTest {

	private static FSM fsm;
	private String className;

	@BeforeClass
	public static void initialize() {
		FSMTest.fsm = new FSM();
	}

	public FSMTest(String className) {
		this.className = className;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"org.greta.ppe.gsbview.GSBLoginBeta"}
		});
	}

	@Test
	public void instance_test() throws 
		ClassNotFoundException, InstantiationException,
		IllegalAccessException {
		Class cls = Class.forName(this.className);	
		GSBLoginBeta gui = (GSBLoginBeta)cls.newInstance();

		assertNotNull(gui);
	}
}
