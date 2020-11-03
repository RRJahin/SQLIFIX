public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT D.DEPARTMENT_ID, MAX(E.SALARY) FROM DEPARTMENTS D, EMPLOYEES E WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND E.LAST_NAME  LIKE '?%' GROUP BY D.DEPARTMENT_ID HAVING AVG(E.SALARY)) <> ?;");
		stmt.setObject(1 , id1);
		stmt.setObject(2 , id2);
		ResultSet rs = stmt.executeQuery();
	}
}