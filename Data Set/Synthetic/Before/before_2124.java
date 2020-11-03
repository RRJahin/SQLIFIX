public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, COMMISSION_PCT, MANAGER_ID FROM EMPLOYEES WHERE COMMISSION_PCT =" + val2+" AND MANAGER_ID =" + rand7;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}