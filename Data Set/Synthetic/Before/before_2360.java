public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeUpdate("Insert into table (Name,email) values("+name+","+email+")");
	}
}