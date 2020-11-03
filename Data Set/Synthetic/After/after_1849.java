public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO SALES_EMPLOYEES (ID, NAME, SALARY, COMMISSION_PCT)
SELECT EMPLOYEE_ID, LAST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE JOB_ID < ? AND SALARY > ?");
		stmt.setObject(1 , id1);
		stmt.setObject(2 , num);
		ResultSet rs = stmt.executeQuery();
	}
}