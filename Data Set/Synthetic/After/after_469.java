public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT DEPARTMENT_NAME
FROM DEPARTMENTS D
WHERE EXISTS
(
SELECT *
FROM EMPLOYEES E
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND SALARY <= ?
)");
		stmt.setObject(1 , num);
		ResultSet rs = stmt.executeQuery();
	}
}