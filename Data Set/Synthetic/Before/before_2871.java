public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT  (FIRST_NAME || '  ' || LAST_NAME) NAME FROM EMPLOYEES WHERE NOT (LAST_NAME LIKE '%"+str+"%')";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}