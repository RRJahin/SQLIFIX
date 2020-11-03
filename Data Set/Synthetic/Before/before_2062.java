public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, SALARY, COMMISSION_PCT FROM EMPLOYEES WHERE SALARY >" + var2+" AND COMMISSION_PCT >" + rand6;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}