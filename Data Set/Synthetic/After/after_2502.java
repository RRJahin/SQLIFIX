public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID FROM JOB_HISTORY WHERE JOB_ID >? AND DEPARTMENT_ID >?");
		stmt.setObject(1 , var1);
		stmt.setObject(2 , rand2);
		ResultSet rs = stmt.executeQuery();
	}
}