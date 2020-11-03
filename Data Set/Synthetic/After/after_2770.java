public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE EMPLOYEES SET SALARY = SALARY * 1.15 WHERE EMPLOYEE_ID = ?");
		stmt.setObject(1 , Id);
		ResultSet rs = stmt.executeUpdate();
	}
}