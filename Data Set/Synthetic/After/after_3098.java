public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT REGION_ID, REGION_NAME FROM REGIONS WHERE REGION_NAME <= ?");
		stmt.setObject(1 , val1);
		stmt.setObject(2 ,  );
		ResultSet rs = stmt.executeQuery();
	}
}