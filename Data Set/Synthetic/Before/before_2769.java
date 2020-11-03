public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES SET SALARY = SALARY * 1.15 WHERE EMPLOYEE_ID = "+Id;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}