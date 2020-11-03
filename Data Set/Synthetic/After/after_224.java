public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("Insert into table (Name,email) values(?,?)");
		stmt.setObject(1 , name);
		stmt.setObject(2 , email);
		ResultSet rs = stmt.executeUpdate();
	}
}