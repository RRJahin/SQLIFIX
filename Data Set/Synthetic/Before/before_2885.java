public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM LOCATIONS WHERE CITY NOT LIKE \'%" + name + "\'");
	}
}