public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM DEPARTMENTS WHERE DEPARTMENT_NAME=(SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE MANAGER_ID=?)");
		stmt.setObject(1 , ID);
		ResultSet rs = stmt.executeQuery();
	}
}