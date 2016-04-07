/**
 * Observer/Obervable tests
 * @author Renaud Tripathi
 */

//import java.lang.reflect.Method;

import java.util.Observable;
import java.util.Observer;

public class ObserverTestUtil implements Observer {
	private String control;

	public ObserverTestUtil() {
		this.control = null;
	}
	public void update(Observable o, Object arg) {
		this.control = (String)arg;
	}

	/**
	 * getter
	 */
	public String get_control_value() {
		return this.control;
	}

	/*
	 * setter like
	 */
	public void reset() {
		this.control = null;
	}
}
