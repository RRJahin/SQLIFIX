public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, HIRE_DATE, JOB_ID FROM EMPLOYEES WHERE HIRE_DATE <>" + var1+" OR JOB_ID <" + rand4;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}