public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT * FROM EMPLOYEES WHERE NVL(COMMISSION_PCT,0) > " + id1 + " OR SALARY <> " + id2 + ";";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}