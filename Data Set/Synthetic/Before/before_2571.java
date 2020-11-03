public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select avg(salary) into average from employees where department_id="+department;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}