public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT into table(employee_id,job_id) values("+eid+","+jid+")";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}