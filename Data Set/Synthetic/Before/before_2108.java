public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, SALARY, COMMISSION_PCT FROM EMPLOYEES WHERE SALARY <>" + val2+" OR COMMISSION_PCT <" + rand6;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}