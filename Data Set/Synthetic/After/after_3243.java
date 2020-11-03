public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM DEPARTMENTS WHERE DEPARTMENT_NAME <> ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , var1);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}