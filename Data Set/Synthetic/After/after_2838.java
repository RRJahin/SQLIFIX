public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT (FIRST_NAME || '  ' || LAST_NAME) NAME, TO_CHAR(HIRE_DATE,'ddth Month,YYYY') H_DATE FROM EMPLOYEES where (date-365)<?");
		stmt.setObject(1 , days);
		ResultSet rs = stmt.executeQuery();
	}
}