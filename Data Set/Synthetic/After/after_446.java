public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO DEPARTMENTS VALUES (?,?,?,?)");
		stmt.setObject(1 , DEPT ID);
		stmt.setObject(2 , DEPT NAME);
		stmt.setObject(3 , MANAGER ID);
		stmt.setObject(4 , LOCATION ID);
		ResultSet rs = stmt.executeUpdate();
	}
}