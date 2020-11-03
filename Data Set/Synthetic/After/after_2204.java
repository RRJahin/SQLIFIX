public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE EMPLOYEES SET
JOB_ID = (SELECT JOB_ID FROM EMPLOYEES WHERE EMPLOYEE_ID = ?),
SALARY = (SELECT SALARY FROM EMPLOYEES WHERE EMPLOYEE_ID = ?)
WHERE EMPLOYEE_ID < ?");
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		ResultSet rs = stmt.executeQuery();
	}
}