public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT INTO DEPARTMENTS VALUES (?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , DEPT ID);
		stmt.setObject(2 , DEPT NAME);
		stmt.setObject(3 , MANAGER ID);
		stmt.setObject(4 , LOCATION ID);
		stmt.executeUpdate();
	}
}