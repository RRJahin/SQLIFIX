public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeUpdate("UPDATE EMPLOYEES SET JOB_ID ="+jobtitle+" , COMMISSION_PCT ="+ commission+" WHERE EMPLOYEE_ID = "+id);
	}
}