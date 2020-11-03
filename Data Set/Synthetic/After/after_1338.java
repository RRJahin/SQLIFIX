public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT *
FROM EMPLOYEES E1
WHERE ? < (
SELECT COUNT(*)
FROM EMPLOYEES E2
WHERE E2.SALARY < E1.SALARY
)");
		stmt.setObject(1 , num);
		ResultSet rs = stmt.executeQuery();
	}
}