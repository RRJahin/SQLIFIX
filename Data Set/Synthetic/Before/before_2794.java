public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("INSERT into schools(id,name) select id,name from topSchools   where teachers> "+counter);
	}
}