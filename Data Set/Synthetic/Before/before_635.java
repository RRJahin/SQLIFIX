public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT *
FROM EMPLOYEES E1
WHERE "+num" = (
SELECT COUNT(*)
FROM EMPLOYEES E2
WHERE E2.SALARY < E1.SALARY
)";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}