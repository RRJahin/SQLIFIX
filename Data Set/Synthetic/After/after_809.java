public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, COMMISSION_PCT FROM EMPLOYEES WHERE COMMISSION_PCT >= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var1);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}