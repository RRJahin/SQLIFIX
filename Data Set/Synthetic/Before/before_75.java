public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, SALARY FROM EMPLOYEES WHERE SALARY =" + val2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}