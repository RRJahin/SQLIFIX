public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES SET JOB_ID = (SELECT JOB_ID FROM EMPLOYEES WHERE EMPLOYEE_ID =?), SALARY = (SELECT SALARY FROM EMPLOYEES WHERE EMPLOYEE_ID =?) WHERE EMPLOYEE_ID =?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		stmt.setObject(3 , id3);
		stmt.executeQuery();
	}
}