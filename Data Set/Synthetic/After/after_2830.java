public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE DEPARTMENTS SET salary=? WHERE DEPARTMENT_ID = ? or job_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , salary);
		stmt.setObject(2 , id1);
		stmt.setObject(3 , id2);
		stmt.executeUpdate();
	}
}