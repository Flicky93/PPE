/**
 * Generic data class for GSB application
 * */

package org.greta.ppe.gsbpack;

public class GSBData {
	public String data;

	public GSBData(String data){
		this.data = data;
	}

	public String toString(){
		return "GSBDATA got " + this.data + "\n";
	}
}
