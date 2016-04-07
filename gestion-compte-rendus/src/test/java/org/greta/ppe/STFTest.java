/**
 * Junit test over STF class
 * @author Renaud Tripathi
 */
import java.util.Arrays;
import java.util.Collection;

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
 * controls insertion behavior
 */
@RunWith(Parameterized.class)
public class STFTest {
	
	private State state;
	private State nextState;
	private Input input;
	private int stateCount;
	private int inputCount;
	public static STF stf;

	/**
	 * primitive STF constructor call.
	 */
	public STFTest(State state,Input input,State nextState,int stateCount,int inputCount){
		this.state = state;
		this.input = input;
		this.nextState = nextState;
		this.stateCount = stateCount;
		this.inputCount = inputCount;
	}

	@BeforeClass
	public static void initialize(){
		stf = new STF();
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{State.INIT,Input.I0,State.INIT,1,1},
			{State.INIT,Input.I1,State.Q1,1,2},
			{State.INIT,Input.I6,State.FINAL,1,3}
		});
	}

	@Test
	/**
	 * Count stf states after each insertion
	 */
	public void state_count(){
		this.stf.register(this.state,this.input,this.nextState);

		assertTrue(
			"Key count Fails with (" + this.state+","+this.input+")",
			this.stf.states().size() == this.stateCount);
	}

	@Test
	/**
	 * Count stf inputs after each insertion
	 */
	public void input_count() {
		this.stf.register(this.state,this.input,this.nextState);

		assertTrue(
			"Value count Fails with (" + this.state+","+this.input+")",
			this.stf.inputs(this.state).size() == this.inputCount);
	}
}
