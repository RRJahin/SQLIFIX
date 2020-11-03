public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM EMPLOYEES WHERE FIRST_NAME=(SELECT FIRST_NAME FROM EMPLOYEES WHERE HIRE_DATE >=TO_DATE(?,'Month DD,YYYY') AND HIRE_DATE<=TO_DATE(?, 1998','Month DD,YYYY'))");
		stmt.setObject(1 , DATE1);
		stmt.setObject(2 , DATE2);
		ResultSet rs = stmt.executeQuery();
	}
}