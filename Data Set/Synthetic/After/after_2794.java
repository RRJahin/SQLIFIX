public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT into schools(id,name) select id,name from topSchools   where teachers>?");
		stmt.setObject(1 , counter);
		ResultSet rs = stmt.executeQuery();
	}
}