public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, MANAGER_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE MANAGER_ID <=? OR DEPARTMENT_ID <?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var1);
		stmt.setObject(2 , rand8);
		stmt.executeQuery();
	}
}