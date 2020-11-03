public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "UPDATE EMPLOYEES SET DEPARTMENT_ID ="+ id1+" WHERE EMPLOYEE_ID =" id2;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}