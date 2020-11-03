public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, EMAIL FROM EMPLOYEES WHERE EMAIL <= ?");
		stmt.setObject(1 , val1);
		stmt.setObject(2 ,  );
		ResultSet rs = stmt.executeQuery();
	}
}