public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM EMPLOYEES WHERE JOB_ID<>?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , ID);
		stmt.executeUpdate();
	}
}