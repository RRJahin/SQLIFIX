public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, LAST_NAME FROM EMPLOYEES WHERE LAST_NAME =" + val2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}