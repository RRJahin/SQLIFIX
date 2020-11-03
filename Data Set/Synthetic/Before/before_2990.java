public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE NVL(COMMISSION_PCT,0) = " + id1 + " OR  SALARY > " + id2 + ";");
	}
}