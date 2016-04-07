/**
 * class STF
 * @author renaud Tripathi
 *
 * State transition function
 */


package org.greta.ppe.gsbutils;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class STF {

	// TODO note on STF 
	private HashMap stf;

	/*
	 * raw constructor
	 */
	public STF(){
		this.stf = new HashMap<State,HashMap<Input,State>>();
	}

	/*
	 * Constructor with configuration argument.
	 * @param config HashMap<State,HashMap<Input,State>>
	 */
	public STF(HashMap<State,HashMap<Input,State>> config){
		this.stf = config;
	}

	/**
	 * Add a new entry in the stf.
	 * @param state
	 * @param input
	 * @param nextState
	 * The regular arguments for this type of matrix.
	 */
	@SuppressWarnings("unchecked")
	public void register(State state, Input input, State nextState) {
		if(this.stf.containsKey(state)) {
			HashMap<Input,State> m = 
				(HashMap<Input,State>)this.stf.get(state);
			if(!m.containsKey(input)) {
				m.put(input,nextState);
			}
		}else{
			HashMap<Input,State> m = new HashMap<Input,State>();
			m.put(input,nextState);
			this.stf.put(state,m);
		}
	}

	/**
	 * Add a new entries in the stf.
	 * @param state
	 * @param qRegister Input x State.
	 * Enhanced version register(State,Input,State).
	 * Accepts all inputs in once thanks to HashMap.
	 */
	@SuppressWarnings("unchecked")
	public void register(State state, HashMap<Input,State> qRegister) {
		if(this.stf.containsKey(state)) {
			HashMap<Input,State> m = 
				(HashMap<Input,State>)this.stf.get(state);
			for(Object o : qRegister.keySet()) {
				Input i = (Input)o;
				if(!m.containsKey(i)) {
					m.put(i,(State)qRegister.get(i));
				}
			}
		}else{
			this.stf.put(state,qRegister);
		}
	}

	/**
	 * return the number of register states
	 * @return The row size of the matrix.
	 */
	public int entry_count(){
		return this.stf.size();
	}

	/**
	 * Return the sum of all defined input
	 */
	public int mapping_count(){
		int sum = 0;
		for(State key : this.states()) {
			sum += this.inputs(key).size();
		}

		return sum;
	}

	/**
	 * Return the defined states.
	 * @return a state list
	 */
	public List<State> states() {
		List<State> keys = new ArrayList<State>();
		for(Object k : this.stf.keySet()) {
			keys.add((State)k);
		}

		return keys;
	}

	/**
	 * Return the defined input for a given state.
	 * @return a Input list
	 */
	@SuppressWarnings("unchecked")
	public List<Input> inputs(State state) {
		List<Input> result = new ArrayList<Input>();
		HashMap<Input,State> reg = 
			(HashMap<Input,State>)this.stf.get(state);
		for(Object o : reg.keySet()) {
			result.add((Input)o);
		}

		return result;
	}

	/**
	 * Read an entry in STF.
	 * @param state State The current state.
	 * @param input Input The input received.
	 * @return State The next state.
	 */
	@SuppressWarnings("unchecked")
	public State next_state(State state, Input input) {
		State nextState;
		try { // exception if no result
			HashMap<Input,State> register = (HashMap<Input,State>)this.stf.get(state);
			nextState = (State)register.get(input);
			nextState.test(); 
		}catch(NullPointerException e) {
			nextState = State.FINAL;
		}

		return nextState;
	}
}
