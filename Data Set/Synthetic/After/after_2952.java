public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES WHERE (SALARY NOT  BETWEEN ? AND ?) OR (SALARY NOT IN (?, ?)) ;";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		stmt.setObject(3 , id3);
		stmt.setObject(4 , id4);
		stmt.executeQuery();
	}
}