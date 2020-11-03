public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT into table(employee_id,job_id) values(?,?)");
		stmt.setObject(1 , eid);
		stmt.setObject(2 , jid);
		ResultSet rs = stmt.executeUpdate();
	}
}