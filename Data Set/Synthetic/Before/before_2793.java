public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT into schools(id,name) select id,name from topSchools   where teachers> "+counter;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}