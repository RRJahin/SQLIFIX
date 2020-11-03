public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT into student(id,name,age) values(?,?,?)");
		stmt.setObject(1 , id);
		stmt.setObject(2 , name);
		stmt.setObject(3 , age);
		ResultSet rs = stmt.executeUpdate();
	}
}