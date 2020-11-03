public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT EMPLOYEE_ID, EMAIL, PHONE_NUMBER FROM EMPLOYEES WHERE EMAIL =" + var1+" OR PHONE_NUMBER =" + rand2;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}