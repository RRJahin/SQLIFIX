public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "INSERT into student(id,name,age) values("+id+","+name+","+"age)";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
	}
}