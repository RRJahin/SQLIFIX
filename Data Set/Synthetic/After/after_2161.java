public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, COMMISSION_PCT, MANAGER_ID FROM EMPLOYEES WHERE COMMISSION_PCT >=? AND MANAGER_ID >?");
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand7);
		ResultSet rs = stmt.executeQuery();
	}
}