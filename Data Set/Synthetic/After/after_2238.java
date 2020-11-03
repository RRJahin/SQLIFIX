public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES SET
JOB_ID = (SELEC?),
SALARY = (SELECT SALARY FROM EMPLOYEES WHERE EMPLOYEE_ID = ?)
WHERE EMPLOYEE_ID <= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		stmt.executeQuery();
	}
}