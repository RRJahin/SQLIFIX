public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES SET SALARY = SALARY * 1.15 WHERE EMPLOYEE_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , Id);
		stmt.executeUpdate();
	}
}