public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME =" + val2+" OR LAST_NAME =" + rand0;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}