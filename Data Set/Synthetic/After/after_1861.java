public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, HIRE_DATE, JOB_ID FROM EMPLOYEES WHERE HIRE_DATE =? OR JOB_ID =?");
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand4);
		ResultSet rs = stmt.executeQuery();
	}
}