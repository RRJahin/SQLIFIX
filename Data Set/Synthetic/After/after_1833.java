public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, PHONE_NUMBER, HIRE_DATE FROM EMPLOYEES WHERE PHONE_NUMBER <=? OR HIRE_DATE <?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var2);
		stmt.setObject(2 , rand3);
		stmt.executeQuery();
	}
}