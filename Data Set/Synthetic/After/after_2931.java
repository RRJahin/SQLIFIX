public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE HIRE_DATE ='?';");
		stmt.setObject(1 , id1);
		ResultSet rs = stmt.executeQuery();
	}
}