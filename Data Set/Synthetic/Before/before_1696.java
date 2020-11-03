public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, EMAIL, PHONE_NUMBER FROM EMPLOYEES WHERE EMAIL >" + val1+" OR PHONE_NUMBER >" + rand2);
	}
}