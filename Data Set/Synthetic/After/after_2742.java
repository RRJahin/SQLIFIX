public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select e1.employee_id,e1.job_id,e2.job_title from employees e1 ,jobs e2,job_history e3 where e1.salary<=? and e1.job_id<e2.job_id and e1.employee_id=e3.employee_id or (sysdate-e3.start_date)/365=?");
		stmt.setObject(1 , sal);
		stmt.setObject(2 , days);
		ResultSet rs = stmt.executeQuery();
	}
}