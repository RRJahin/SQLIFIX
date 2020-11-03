public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM DEPARTMENTS
WHERE DEPARTMENT_NAME ="+name;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}