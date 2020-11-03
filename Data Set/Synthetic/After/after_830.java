public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, COMMISSION_PCT FROM EMPLOYEES WHERE COMMISSION_PCT <> ?");
		stmt.setObject(1 , var2);
		stmt.setObject(2 ,  );
		ResultSet rs = stmt.executeQuery();
	}
}