public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES WHERE NVL(COMMISSION_PCT,0) > ? AND SALARY < ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		stmt.executeQuery();
	}
}