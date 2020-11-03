public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM DEPARTMENTS
WHERE DEPARTMENT_ID IN ("+id1+", "+id2+")";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}