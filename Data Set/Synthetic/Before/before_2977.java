public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "Insert into table (Name,email) values("+name+","+email+")";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}