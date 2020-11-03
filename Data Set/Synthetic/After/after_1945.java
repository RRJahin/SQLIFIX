public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, JOB_ID, SALARY FROM EMPLOYEES WHERE JOB_ID =? OR SALARY =?");
		stmt.setObject(1 , val1);
		stmt.setObject(2 , rand5);
		ResultSet rs = stmt.executeQuery();
	}
}