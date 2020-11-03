public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_NAME
FROM DEPARTMENTS D
WHERE EXISTS
(
SELECT *
FROM EMPLOYEES E
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND SALARY < ?
)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , num);
		stmt.executeQuery();
	}
}