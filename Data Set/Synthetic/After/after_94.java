public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, SALARY FROM EMPLOYEES WHERE SALARY >= ?");
		stmt.setObject(1 , val2);
		stmt.setObject(2 ,  );
		ResultSet rs = stmt.executeQuery();
	}
}