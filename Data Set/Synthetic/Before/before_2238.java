public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES SET
JOB_ID = (SELECT JOB_ID FROM EMPLOYEES WHERE EMPLOYEE_ID = "+id2+"),
SALARY = (SELECT SALARY FROM EMPLOYEES WHERE EMPLOYEE_ID = "+id2+")
WHERE EMPLOYEE_ID <= "+id1;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}