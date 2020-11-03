public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employees where employee_id=any( select employee_id from employees where department_id = any ( select department_id from departments where location_id=any( select location_id from locations where country_id=( select country_id from countries where upper(country_name) like" + name + "))))");
	}
}