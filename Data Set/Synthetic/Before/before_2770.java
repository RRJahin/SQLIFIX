public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeUpdate("UPDATE EMPLOYEES SET SALARY = SALARY * 1.15 WHERE EMPLOYEE_ID = "+Id);
	}
}