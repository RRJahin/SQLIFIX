public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeUpdate("UPDATE DEPARTMENTS SET salary="+salary+" WHERE DEPARTMENT_ID ="+id1+" or job_id= "+id2);
	}
}