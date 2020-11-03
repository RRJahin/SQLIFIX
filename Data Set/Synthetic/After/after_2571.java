public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select avg(salary) into average from employees where department_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , department);
		stmt.executeQuery();
	}
}