public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_NAME=(SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE MANAGER_ID=?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , ID);
		stmt.executeQuery();
	}
}