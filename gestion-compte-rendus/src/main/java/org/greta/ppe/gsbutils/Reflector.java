/**
 * Introspection class utility
 * @author Renaud Tripathi
 */

package org.greta.ppe.gsbutils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Reflector<T> {

	private T t;
	private Class c;

	public Reflector(T t) {
		this.t = t;
		this.c = this.t.getClass();
	}

	/**
	 * Return the public field specified by its name.
	 * @param fieldName String the name's field.
	 * @return The field object or null.
	 */
	public Field get_public_field(String fieldName) {
		Field[] f = this.c.getFields();
		for(int i=0;i<f.length;i++) {
			if(f[i].getName().equals(fieldName)) {
				return f[i];
			}
		}

		return null;
	}

	/**
	 * Return the field private field specified by its name.
	 * @param fieldName String the name's field.
	 * @return The field object or null.
	 */
	public Field get_private_field(String fieldName) {
		Field[] f = this.c.getDeclaredFields();
		for(int i=0;i<f.length;i++) {
			if(f[i].getName().equals(fieldName) 
				&& f[i].getModifiers() == Modifier.PRIVATE) {
				return f[i];
			}
		}

		return null;
	}
}
