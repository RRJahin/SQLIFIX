public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_ID, MANAGER_ID FROM DEPARTMENTS WHERE MANAGER_ID <= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var2);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}