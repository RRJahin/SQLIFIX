public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM DEPARTMENTS
WHERE DEPARTMENT_NAME =?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , name);
		stmt.executeUpdate();
	}
}