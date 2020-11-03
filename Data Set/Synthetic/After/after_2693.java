public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select max(salary)Max_salary from employees group by department_id having min(salary)<=? order by Max_salary asc");
		stmt.setObject(1 , sal);
		ResultSet rs = stmt.executeQuery();
	}
}