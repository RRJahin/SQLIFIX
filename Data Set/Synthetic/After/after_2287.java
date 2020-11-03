public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, MANAGER_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE MANAGER_ID <>? OR DEPARTMENT_ID <?");
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand8);
		ResultSet rs = stmt.executeQuery();
	}
}