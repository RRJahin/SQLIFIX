public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeUpdate("INSERT into student(id,name,age) values("+id+","+name+","+"age)");
	}
}