public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT EMPLOYEE_ID, END_DATE, JOB_ID FROM JOB_HISTORY WHERE END_DATE =" + var2+" OR JOB_ID =" + rand1);
	}
}