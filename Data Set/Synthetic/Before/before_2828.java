public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE DEPARTMENTS SET salary="+salary+" WHERE DEPARTMENT_ID IN ("+id1+", "+id2+")";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}