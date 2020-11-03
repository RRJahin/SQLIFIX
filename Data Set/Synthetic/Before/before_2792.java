public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("INSERT INTO SALES_EMPLOYEES (ID, NAME) SELECT EMPLOYEE_ID, LAST_NAME FROM EMPLOYEES WHERE age>"+age);
	}
}