public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, START_DATE, END_DATE FROM JOB_HISTORY WHERE START_DATE >=? OR END_DATE >?");
		stmt.setObject(1 , var2);
		stmt.setObject(2 , rand0);
		ResultSet rs = stmt.executeQuery();
	}
}