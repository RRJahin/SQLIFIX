public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM DEPARTMENTS
WHERE DEPARTMENT_ID IN (?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		stmt.executeUpdate();
	}
}