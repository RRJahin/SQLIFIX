public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeUpdate("INSERT into table(employee_id,job_id) values("+eid+","+jid+")");
	}
}