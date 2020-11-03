public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, DEPARTMENT_ID FROM JOB_HISTORY WHERE DEPARTMENT_ID <> ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val2);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}