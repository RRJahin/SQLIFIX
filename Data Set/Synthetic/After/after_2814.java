public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT DEPARTMENT_NAME  FROM DEPARTMENTS WHERE DEPARTMENT_ID=ANY (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE JOB_ID LIKE ?)");
		stmt.setObject(1 , jobtitle);
		ResultSet rs = stmt.executeQuery();
	}
}