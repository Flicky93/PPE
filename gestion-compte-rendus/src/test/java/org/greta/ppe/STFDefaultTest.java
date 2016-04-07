/**
 * Junit test over STF class
 * @author Renaud Tripathi
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assume.assumeTrue;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assert.assertTrue;

import org.greta.ppe.gsbutils.STF;
import org.greta.ppe.gsbutils.State;
import org.greta.ppe.gsbutils.Input;

/**
 * Test the exception system
 */
@RunWith(Parameterized.class)
public class STFDefaultTest {
	
	private State state;
	private Input input;
	private String expected;
	public static STF stf;

	public STFDefaultTest(State state, Input input, String expected){ 
		this.state = state;
		this.input = input;
		this.expected = expected;
	}

	/**
	 * primitive STF constructor call.
	 */
	@BeforeClass
	@SuppressWarnings("unchecked")
	public static void initialize(){
		stf = new STF(new HashMap<State,HashMap<Input,State>>() {{
			put(State.INIT,
				new HashMap() {{
					put(Input.I0,State.INIT);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.FINAL);}});
			put(State.Q1,
				new HashMap() {{
					put(Input.I0,State.Qz);
					put(Input.I1,State.Qz);
					put(Input.I2,State.Q2);
					put(Input.I3,State.Q3);
					put(Input.I4,State.Q4);
					put(Input.I5,State.Q5);
					put(Input.I6,State.FINAL);}});
		}});
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{State.Q2,Input.I1,"Final"}, {State.Q5,Input.I0,"Final"}
			}); 
	}

	@Test
	/**
	 * Test next_state function with
	 * undefined entries. Should return 
	 * a final state.
	 */
	public void next_state_default_test(){

		State nextState = this.stf.next_state(this.state,this.input);
		assertTrue(
			"next_state fails with (" + this.state + "," + this.input + ")",
			nextState.label() == this.expected);
	}
}
