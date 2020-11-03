public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, END_DATE, JOB_ID FROM JOB_HISTORY WHERE END_DATE >=? OR JOB_ID >?");
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand1);
		ResultSet rs = stmt.executeQuery();
	}
}