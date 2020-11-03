public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT JOB_ID, JOB_TITLE FROM JOBS WHERE JOB_TITLE <= ?");
		stmt.setObject(1 , val2);
		stmt.setObject(2 ,  );
		ResultSet rs = stmt.executeQuery();
	}
}