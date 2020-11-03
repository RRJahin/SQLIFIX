public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select e1.employee_id,e1.job_id,e2.job_title from employees e1 ,jobs e2,job_history e3 where e1.salary<="+sal+" and e1.job_id>e2.job_id and e1.employee_id=e3.employee_id and (sysdate-e3.start_date)/365>="+ days;
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}