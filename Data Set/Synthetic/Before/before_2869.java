public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_NAME=(SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE MANAGER_ID="+ID+")";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}