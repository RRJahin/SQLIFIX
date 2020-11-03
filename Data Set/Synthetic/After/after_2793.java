public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT into schools(id,name) select id,name from topSchools   where teachers>?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , counter);
		stmt.executeQuery();
	}
}