public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT INTO SALES_EMPLOYEES (ID, NAME) SELECT EMPLOYEE_ID, LAST_NAME FROM EMPLOYEES WHERE age>?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , age);
		stmt.executeQuery();
	}
}