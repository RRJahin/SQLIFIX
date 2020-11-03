public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE (SALARY NOT  BETWEEN ? AND ?) AND (SALARY NOT IN (?, ?)) ;");
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		stmt.setObject(3 , id3);
		stmt.setObject(4 , id4);
		ResultSet rs = stmt.executeQuery();
	}
}