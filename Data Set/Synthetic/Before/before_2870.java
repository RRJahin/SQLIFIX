public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("DELETE FROM DEPARTMENTS WHERE DEPARTMENT_NAME=(SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE MANAGER_ID="+ID+")");
	}
}