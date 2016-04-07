/**
 * GUIThreadTestUtil class
 * Thread test utility
 * @author Renaud Tripathi
 */

import org.greta.ppe.gsbcontroller.GSBController;

/**
 * Run some controller's function
 * in a separate thread
 */
public class GUIThreadTestUtil <C extends GSBController> implements Runnable {

	private C c;

	public GUIThreadTestUtil(C c) {
		this.c = c;
	}

	@Override
	public void run() {
		this.c.display_view();
	}
}
