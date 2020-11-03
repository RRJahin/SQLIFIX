public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE EMPLOYEES SET DEPARTMENT_ID =? WHERE EMPLOYEE_ID >?");
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		ResultSet rs = stmt.executeUpdate();
	}
}