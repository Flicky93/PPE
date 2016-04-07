/**
 * File name : GSBController.java
 * @author Renaud Tripathi
 * 
 * A unique controller to rule them all.
 * */

 package org.greta.ppe.gsbcontroller;
 
 import java.util.HashMap;

 import org.greta.ppe.gsbutils.State;
 import org.greta.ppe.gsbutils.Input;
 import org.greta.ppe.gsbutils.STF;
 import org.greta.ppe.gsbview.*; // full require

public class FSM {

	private STF stf;
	private State state;

	@SuppressWarnings("unchecked")
	public FSM() {
		this.stf = new STF(new HashMap<State,HashMap<Input,State>>() {{
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
					put(Input.I1,State.Q1);
					put(Input.I2,State.Qz);
					put(Input.I3,State.Qz);
					put(Input.I4,State.Qz);
					put(Input.I5,State.Qz);
					put(Input.I6,State.Qz);}});	
		}});
		this.state = State.INIT;
	}

	/**
	 * perform state's tasks and perform
	 * a state update.
	 * */
	public void live(){
	}

	/**
	 * Check if the controller is in final state
	 * @return Boolean
	 * */
	public boolean alive(){
		return this.state != State.FINAL;
	}
}
