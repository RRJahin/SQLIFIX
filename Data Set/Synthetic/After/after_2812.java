public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT COMMISSION_PCT FROM EMPLOYEES WHERE NVL(COMMISSION_PCT,0)<?");
		stmt.setObject(1 , percentage);
		ResultSet rs = stmt.executeQuery();
	}
}