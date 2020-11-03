public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, EMAIL FROM EMPLOYEES WHERE EMAIL >=" + var2);
	}
}