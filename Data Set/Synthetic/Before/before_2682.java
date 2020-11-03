public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select max(salary)Max_salary from employees group by department_id having min(salary)<="+sal+" order by Max_salary asc";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}