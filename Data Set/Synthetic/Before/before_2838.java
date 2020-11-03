public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT (FIRST_NAME || '  ' || LAST_NAME) NAME, TO_CHAR(HIRE_DATE,'ddth Month,YYYY') H_DATE FROM EMPLOYEES where (date-365)<"+days);
	}
}