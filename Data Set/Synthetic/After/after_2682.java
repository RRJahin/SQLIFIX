public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select max(salary)Max_salary from employees group by department_id having min(salary)<=? order by Max_salary asc";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , sal);
		stmt.executeQuery();
	}
}