public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE DEPARTMENTS SET salary="+salary+" WHERE DEPARTMENT_ID ="+id1+" and job_id= "+id2;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}