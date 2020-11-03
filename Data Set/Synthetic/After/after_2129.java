public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, COMMISSION_PCT, MANAGER_ID FROM EMPLOYEES WHERE COMMISSION_PCT =? AND MANAGER_ID =?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var1);
		stmt.setObject(2 , rand7);
		stmt.executeQuery();
	}
}