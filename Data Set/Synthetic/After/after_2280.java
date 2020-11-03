public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, MANAGER_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE MANAGER_ID <>? AND DEPARTMENT_ID <?");
		stmt.setObject(1 , val1);
		stmt.setObject(2 , rand8);
		ResultSet rs = stmt.executeQuery();
	}
}