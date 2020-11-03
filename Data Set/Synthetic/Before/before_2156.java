public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, COMMISSION_PCT, MANAGER_ID FROM EMPLOYEES WHERE COMMISSION_PCT >=" + val1+" AND MANAGER_ID >" + rand7);
	}
}