public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, PHONE_NUMBER FROM EMPLOYEES WHERE PHONE_NUMBER =" + var2);
	}
}