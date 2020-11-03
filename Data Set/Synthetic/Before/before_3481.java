public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, PHONE_NUMBER FROM EMPLOYEES WHERE PHONE_NUMBER >" + val2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}