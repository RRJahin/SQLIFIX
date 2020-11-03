public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES SET JOB_ID ="+jobtitle+" , COMMISSION_PCT ="+ commission+" WHERE EMPLOYEE_ID <>"+id;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}