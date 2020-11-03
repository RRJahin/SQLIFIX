public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_NAME  FROM DEPARTMENTS WHERE DEPARTMENT_ID=ANY (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE JOB_ID LIKE "+jobtitle+")";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}