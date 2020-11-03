public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeUpdate("UPDATE DEPARTMENTS SET salary="+salary+" WHERE DEPARTMENT_ID IN ("+id1+", "+id2+")");
	}
}