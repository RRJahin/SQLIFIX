public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM EMPLOYEES WHERE JOB_ID<>?");
		stmt.setObject(1 , ID);
		ResultSet rs = stmt.executeUpdate();
	}
}