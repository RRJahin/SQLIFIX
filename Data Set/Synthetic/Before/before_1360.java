public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT *
FROM EMPLOYEES E1
WHERE "+num" > (
SELECT COUNT(*)
FROM EMPLOYEES E2
WHERE E2.SALARY < E1.SALARY
)");
	}
}