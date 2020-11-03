public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM EMPLOYEES WHERE FIRST_NAME=(SELECT FIRST_NAME FROM EMPLOYEES WHERE HIRE_DATE =TO_DATE("+DATE1+",'Month DD,YYYY') AND HIRE_DATE=TO_DATE("+DATE2+", 1998','Month DD,YYYY'))";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}