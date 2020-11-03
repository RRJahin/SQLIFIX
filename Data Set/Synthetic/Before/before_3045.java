public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT D.DEPARTMENT_ID, MAX(E.SALARY) FROM DEPARTMENTS D, EMPLOYEES E WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND E.LAST_NAME NOT LIKE '" + id1 + "%' GROUP BY D.DEPARTMENT_ID HAVING AVG(E.SALARY)) = " + id2 + ";");
	}
}