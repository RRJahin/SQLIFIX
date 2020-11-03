public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT COMMISSION_PCT FROM EMPLOYEES WHERE NVL(COMMISSION_PCT,0)>=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , percentage);
		stmt.executeQuery();
	}
}