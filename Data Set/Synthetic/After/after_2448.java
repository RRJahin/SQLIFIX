public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM DEPARTMENTS
WHERE DEPARTMENT_ID IN (?, ?)");
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		ResultSet rs = stmt.executeUpdate();
	}
}