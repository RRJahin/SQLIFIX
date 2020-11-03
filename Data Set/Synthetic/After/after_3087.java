public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "SELECT REGION_ID, REGION_NAME FROM REGIONS WHERE REGION_NAME >= ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , val1);
		stmt.setObject(2 ,  );
		stmt.executeQuery();
	}
}