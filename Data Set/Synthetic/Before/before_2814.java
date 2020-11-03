public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT DEPARTMENT_NAME  FROM DEPARTMENTS WHERE DEPARTMENT_ID=ANY (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE JOB_ID LIKE "+jobtitle+")");
	}
}