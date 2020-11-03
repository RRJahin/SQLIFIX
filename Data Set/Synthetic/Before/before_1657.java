public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, LAST_NAME, EMAIL FROM EMPLOYEES WHERE LAST_NAME <>" + val1+" AND EMAIL <" + rand1);
	}
}