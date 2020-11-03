public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, COMMISSION_PCT FROM EMPLOYEES WHERE COMMISSION_PCT <=" + val1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}