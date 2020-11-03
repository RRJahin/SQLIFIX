public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT  (FIRST_NAME || '  ' || LAST_NAME) NAME FROM EMPLOYEES WHERE JOB_ID="+id+" AND SALARY>="+salary;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}