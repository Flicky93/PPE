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
 * Test the next_state function
 */
@RunWith(Parameterized.class)
public class STFConfigTest {
	
	private State state;
	private Input input;
	private String expected;
	public static STF stf;

	public STFConfigTest(State state, Input input, String expected){ 
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
			put(State.Q2,
				new HashMap() {{
					put(Input.I0,State.Q2);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.FINAL);}});
			put(State.Q3,
				new HashMap() {{
					put(Input.I0,State.Q3);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.FINAL);}});
			put(State.Q4,
				new HashMap() {{
					put(Input.I0,State.Q4);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.FINAL);}});
			put(State.Q5,
				new HashMap() {{
					put(Input.I0,State.Q5);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.FINAL);}});
			put(State.FINAL,
				new HashMap() {{
					put(Input.I0,State.Qz);
					put(Input.I1,State.Qz);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.Qz);}});	
		}});
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{State.INIT,Input.I0,"Login"},{State.Q2,Input.I1,"Menu"},
			{State.Q1,Input.I3,"Visitor"},{State.Q1,Input.I5,"Drug"},
			{State.Q5,Input.I6,"Final"}
			}); 
	}

	@Test
	/**
	 * Test next_state function.
	 */
	public void next_state_test(){

		State nextState = this.stf.next_state(this.state,this.input);
		assertTrue(
			"next_state fails with (" + this.state +"," + this.input + ")",
			nextState.label() == this.expected);
	}
}
