public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, SALARY, COMMISSION_PCT FROM EMPLOYEES WHERE SALARY <=? OR COMMISSION_PCT <?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val1);
		stmt.setObject(2 , rand6);
		stmt.executeQuery();
	}
}