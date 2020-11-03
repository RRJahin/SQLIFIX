public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT DEPARTMENT_ID, LOCATION_ID FROM DEPARTMENTS WHERE LOCATION_ID =" + var1);
	}
}