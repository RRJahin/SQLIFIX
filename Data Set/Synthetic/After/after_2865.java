public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM EMPLOYEES WHERE FIRST_NAME<>(SELECT FIRST_NAME FROM EMPLOYEES WHERE HIRE_DATE >=TO_DATE(?,'Month DD,YYYY') AND HIRE_DATE<=TO_DATE(?, 1998','Month DD,YYYY'))";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , DATE1);
		stmt.setObject(2 , DATE2);
		stmt.executeQuery();
	}
}