public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select e1.employee_id,e1.job_id,e2.job_title from employees e1 ,jobs e2,job_history e3 where e1.salary<=? and e1.job_id>e2.job_id and e1.employee_id=e3.employee_id and (sysdate-e3.start_date)/365>=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setObject(1 , sal);
		stmt.setObject(2 , days);
		stmt.executeQuery();
	}
}