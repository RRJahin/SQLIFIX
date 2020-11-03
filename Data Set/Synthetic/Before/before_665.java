public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME =" + var2+" OR MANAGER_ID =" + rand0;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}