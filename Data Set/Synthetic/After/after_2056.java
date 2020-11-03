public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT EMPLOYEE_ID, SALARY, COMMISSION_PCT FROM EMPLOYEES WHERE SALARY >? OR COMMISSION_PCT >?");
		stmt.setObject(1 , val2);
		stmt.setObject(2 , rand6);
		ResultSet rs = stmt.executeQuery();
	}
}