public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "Insert into table (Name,email) values(?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , name);
		stmt.setObject(2 , email);
		stmt.executeUpdate();
	}
}