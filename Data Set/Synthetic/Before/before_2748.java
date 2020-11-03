public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		String sql = "select V1.owner_id, count(*) AS Number_of_Vehicles from vehicle V1 where V1.owner_id in (select owner_id from owner where owner_id>"+id") group by V1.owner_id having count(*)>="+counter+" order by Number_of_Vehicles DESC,V1.owner_id";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
	}
}