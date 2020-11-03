public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO SALES_EMPLOYEES (ID, NAME) SELECT EMPLOYEE_ID, LAST_NAME FROM EMPLOYEES WHERE age>?");
		stmt.setObject(1 , age);
		ResultSet rs = stmt.executeQuery();
	}
}