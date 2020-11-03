public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT D.DEPARTMENT_ID, MAX(E.SALARY) FROM DEPARTMENTS D, EMPLOYEES E WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND E.LAST_NAME NOT LIKE '?%' GROUP BY D.DEPARTMENT_ID HAVING AVG(E.SALARY)) <> ?;";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		stmt.executeQuery();
	}
}