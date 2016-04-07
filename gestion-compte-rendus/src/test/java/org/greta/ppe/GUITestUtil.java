/**
 * Utility class for GUI testing
 * @author Renaud Tripathi
 */

import java.awt.Component;
import java.awt.Container;

public class GUITestUtil {

	/**
	 * return a component from the ui
	 * tree access by its name.
	 * @param parent Component a component element.
	 * @param name String the name of the component as
	 * defined in the gui declaration by the setName method.
	 */
	public static Component component_by_name(Component parent, String name) {
		if(name.equals(parent.getName())) {
			return parent;
		} else if(parent instanceof Container) {
			Component[] c = ((Container)parent).getComponents();
			for(int i=0;i<c.length;i++) {
				Component child = GUITestUtil.component_by_name(c[i],name);
				if(child != null) {
					return child;
				}
			}
		}
		return null;
	}
}
