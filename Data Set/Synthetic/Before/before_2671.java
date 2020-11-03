public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select max(salary)Max_salary from employees group by department_id having min(salary)>"+sal+" order by Max_salary asc");
	}
}