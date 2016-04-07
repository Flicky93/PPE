/**
 * Classe mère des modeles
 * @author Renaud Tripathi
 */

 package org.greta.ppe.gsbmodel;

 import java.util.Vector;

 import java.sql.ResultSet;
 import java.sql.SQLException;

 import org.greta.ppe.gsbcontroller.GSBController;
 import org.greta.ppe.gsbpack.*;


 public class GSBTestModel extends GSBModel {

	public GSBTestModel(GSBController controller) { // singleton or not singleton ?
		super();
		System.out.println("In GSBTestModel\n");
	}
	/**
	 * Retreive a test sample from test database
	 * @return <code>Vector</code>
	 * */
	public Vector<GSBTestResult> rTest(){
		Vector<GSBTestResult> results = new Vector<GSBTestResult>();
		try{
		this.connect();
		this.stmt = this.conn.createStatement();
		String sql = "select * from persons";
		ResultSet r = this.stmt.executeQuery(sql);
		while(r.next()){
			GSBTestResult rs = new GSBTestResult();
			rs.setId(r.getInt("id"));
			rs.setFirstName(r.getString("first_name"));
			rs.setLastName(r.getString("last_name"));
			results.add(rs);
		}
		r.close();
		this.stmt.close();
		this.conn.close();
		}catch(SQLException se){
			//
		}catch(Exception e){
		}finally{
			try{
				if(this.stmt!=null){
					this.stmt.close();
				}
			}catch(SQLException se2){
				//
			}try{
				if(this.conn!=null){
					this.conn.close();
				}
			}catch(SQLException se){
			}
		}

		return results;
	}
 }
