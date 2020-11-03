public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select avg(salary) into average from employees where department_id=?");
		stmt.setObject(1 , department);
		ResultSet rs = stmt.executeQuery();
	}
}