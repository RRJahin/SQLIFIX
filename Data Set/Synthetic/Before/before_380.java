public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT DEPARTMENT_NAME
FROM DEPARTMENTS D
WHERE EXISTS
(
SELECT *
FROM EMPLOYEES E
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID OR JOB_ID <> "+id"
)");
	}
}