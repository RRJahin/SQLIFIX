public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT INTO SALES_EMPLOYEES (ID, NAME, SALARY, COMMISSION_PCT)
SELECT EMPLOYEE_ID, LAST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE JOB_ID >"+ id1+" AND SALARY > "+num;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}