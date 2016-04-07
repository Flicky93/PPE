/**
 * A TestClass bean like allowing Model 
 * to return results
 * */

package org.greta.ppe.gsbpack;

public class GSBTestResult {

	private int id;
	private String firstName;
	private String lastName;

	public GSBTestResult(){}

	public void setId(Integer id){
		this.id = id;
	}

	public void setFirstName(String name){
		this.firstName = name;
	}

	public void setLastName(String name){
		this.lastName = name;
	}

	public int getId(Integer id){
		return this.id;
	}

	public String getFirstName(String name){
		return this.firstName;
	}

	public String getLastName(String name){
		return this.lastName;
	}

	public String toString(){
		return "id:"+this.id+"\n"+this.firstName+"\n"+this.lastName+"\n";
	}
}
