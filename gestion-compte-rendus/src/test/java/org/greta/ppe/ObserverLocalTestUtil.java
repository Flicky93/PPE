/**
 * Observer/Obervable tests
 * @author Renaud Tripathi
 */

//import java.lang.reflect.Method;

import java.util.Observable;
import java.util.Observer;

public class ObserverLocalTestUtil implements Observer {
	
	Object control;

	public ObserverLocalTestUtil() {
		this.control = null;
	}
	public void update(Observable o, Object arg) {
		this.control = arg;
	}

	/**
	 * getter
	 */
	public Object get_control_value() {
		return this.control;
	}

	/*
	 * setter like
	 */
	public void reset() {
		this.control = null;
	}
}
