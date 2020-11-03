public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, LAST_NAME, EMAIL FROM EMPLOYEES WHERE LAST_NAME <=? AND EMAIL <?");
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand1);
		ResultSet rs = stmt.executeQuery();
	}
}