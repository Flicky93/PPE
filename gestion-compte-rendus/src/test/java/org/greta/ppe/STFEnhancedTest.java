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
 * Test the enhancedd register function
 */
@RunWith(Parameterized.class)
public class STFEnhancedTest {
	
	private State state;
	private HashMap<Input,State> register;
	private int stateCount;
	private int inputCount;
	public static STF stf;

	/**
	 * primitive STF constructor call.
	 */
	public STFEnhancedTest(State state,HashMap<Input,State> register,int stateCount,int inputCount) {
		this.state = state;
		this.register = register;
		this.stateCount = stateCount;
		this.inputCount = inputCount;
	}

	@BeforeClass
	public static void initialize(){
		stf = new STF();
	}

	@Parameterized.Parameters
	@SuppressWarnings("unchecked")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{State.INIT,
				new HashMap() {{
					put(Input.I0,State.INIT);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.FINAL);}},1,7},
			{State.Q1,
				new HashMap() {{
					put(Input.I0,State.Qz);
					put(Input.I1,State.Qz);
					put(Input.I2,State.Q2);
					put(Input.I3,State.Q3);
					put(Input.I4,State.Q4);
					put(Input.I5,State.Q5);
					put(Input.I6,State.FINAL);}},2,14},
			{State.Q2,
				new HashMap() {{
					put(Input.I0,State.Q2);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.FINAL);}},3,21},
			{State.Q3,
				new HashMap() {{
					put(Input.I0,State.Q3);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.FINAL);}},4,28},
			{State.Q4,
				new HashMap() {{
					put(Input.I0,State.Q4);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.FINAL);}},5,35},
			{State.Q5,
				new HashMap() {{
					put(Input.I0,State.Q5);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.FINAL);}},6,42},
			{State.FINAL,
				new HashMap() {{
					put(Input.I0,State.Qz);
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.Qz);}},7,49},
		});
	}

	@Test
	/**
	 * Count stf states after each insertion
	 */
	public void state_count(){
		this.stf.register(this.state,this.register);

		assertTrue(
			"Key count Fails with (" + this.state + "," + 
			this.register +")\n expected " + this.stateCount 
			+ " got " + this.stf.states().size(), 
			this.stf.entry_count() == this.stateCount);
	}

	@Test
	/**
	 * Count stf mapped values
	 */
	public void mapping_count() {
		this.stf.register(this.state,this.register);

		assertTrue(
			"Value count Fails with (" + this.state + "," +
			this.register + ")\n expected " + this.inputCount
			+ " got " + this.stf.inputs(this.state).size(),
			this.stf.mapping_count() == this.inputCount);
	}
}
