public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT (FIRST_NAME || '  ' || LAST_NAME) NAME, TO_CHAR(HIRE_DATE,'ddth Month,YYYY') H_DATE FROM EMPLOYEES where (date-365)=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , days);
		stmt.executeQuery();
	}
}