public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, SALARY, COMMISSION_PCT FROM EMPLOYEES WHERE SALARY >" + var1+" AND COMMISSION_PCT >" + rand6);
	}
}