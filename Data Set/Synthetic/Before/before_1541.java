public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME FROM EMPLOYEES WHERE FIRST_NAME >=" + var1+" AND LAST_NAME >" + rand0;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}