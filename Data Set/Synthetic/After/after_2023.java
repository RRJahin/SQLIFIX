public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, JOB_ID, SALARY FROM EMPLOYEES WHERE JOB_ID <>? AND SALARY <?");
		stmt.setObject(1 , var1);
		stmt.setObject(2 , rand5);
		ResultSet rs = stmt.executeQuery();
	}
}