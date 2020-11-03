public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT into table(employee_id,job_id) values(?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , eid);
		stmt.setObject(2 , jid);
		stmt.executeUpdate();
	}
}