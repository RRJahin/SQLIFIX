public class Dummy {
void sendRequest(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT JOB_ID, MIN_SALARY, MAX_SALARY FROM JOBS WHERE MIN_SALARY <=" + var1+" AND MAX_SALARY <" + rand1);
	}
}