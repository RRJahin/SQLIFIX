public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE NVL(COMMISSION_PCT,0) > ? AND SALARY = ?;");
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		ResultSet rs = stmt.executeQuery();
	}
}