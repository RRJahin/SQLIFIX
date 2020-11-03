public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT COMMISSION_PCT FROM EMPLOYEES WHERE NVL(COMMISSION_PCT,0)<"+percentage);
	}
}