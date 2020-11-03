public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT *
FROM EMPLOYEES E1
WHERE ? <= (
SELECT COUNT(*)
FROM EMPLOYEES E2
WHERE E2.SALARY < E1.SALARY
)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , num);
		stmt.executeQuery();
	}
}