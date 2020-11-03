public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT into student(id,name,age) values(?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id);
		stmt.setObject(2 , name);
		stmt.setObject(3 , age);
		stmt.executeUpdate();
	}
}