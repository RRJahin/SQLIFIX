public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES WHERE FIRST_NAME <=" + var2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}