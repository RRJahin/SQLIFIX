public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM DEPARTMENTS
WHERE DEPARTMENT_NAME LIKE ?");
		stmt.setObject(1 , name);
		ResultSet rs = stmt.executeUpdate();
	}
}