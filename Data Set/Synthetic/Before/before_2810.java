public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT COMMISSION_PCT FROM EMPLOYEES WHERE NVL(COMMISSION_PCT,0)<"+percentage;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}