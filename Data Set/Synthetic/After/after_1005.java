public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT DEPARTMENT_NAME
FROM DEPARTMENTS D
WHERE EXISTS
(
SELECT *
FROM EMPLOYEES E
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID AND JOB_ID <> ?
)");
		stmt.setObject(1 , id);
		ResultSet rs = stmt.executeQuery();
	}
}