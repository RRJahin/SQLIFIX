public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES WHERE FIRST_NAME = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val2);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}