public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES
SET DEPARTMENT_ID = 50
WHERE EMPLOYEE_ID < ?" ;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.executeUpdate();
	}
}