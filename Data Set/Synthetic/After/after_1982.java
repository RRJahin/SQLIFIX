public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE EMPLOYEES
SET DEPARTMENT_ID = 50
WHERE EMPLOYEE_ID LIKE ?" );
		stmt.setObject(1 , id1);
		ResultSet rs = stmt.executeUpdate();
	}
}