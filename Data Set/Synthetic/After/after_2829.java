public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("UPDATE DEPARTMENTS SET salary=? WHERE DEPARTMENT_ID IN (?,?)");
		stmt.setObject(1 , salary);
		stmt.setObject(2 , id1);
		stmt.setObject(3 , id2);
		ResultSet rs = stmt.executeUpdate();
	}
}