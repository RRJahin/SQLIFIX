public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT JOB_ID, JOB_TITLE FROM JOBS WHERE JOB_TITLE = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var2);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}