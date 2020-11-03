public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT (FIRST_NAME || '  ' || LAST_NAME) NAME, TO_CHAR(HIRE_DATE,'ddth Month,YYYY') H_DATE FROM EMPLOYEES where (date-365)="+days;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}