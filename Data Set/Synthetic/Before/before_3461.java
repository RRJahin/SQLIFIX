public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, EMAIL FROM EMPLOYEES WHERE EMAIL <>" + val1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}