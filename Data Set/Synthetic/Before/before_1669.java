public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, LAST_NAME, EMAIL FROM EMPLOYEES WHERE LAST_NAME <>" + var2+" AND EMAIL <" + rand1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}