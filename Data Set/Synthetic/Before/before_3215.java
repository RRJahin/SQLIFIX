public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM DEPARTMENTS WHERE DEPARTMENT_NAME >" + val2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}