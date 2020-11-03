public class Dummy{
@Test
public void testSelectUsersAndPosts() throws SQLException {
    DbManager dbManager = DbManager.getInstance();
    String sqlQuerry = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_COUNT\n" + "FROM POSTS P, USERS U\n" + "WHERE U.ID = P.USER_ID\n" + "GROUP BY USER_ID\n" + "HAVING COUNT(*) >= 2;";
    Statement statement = dbManager.getConnection().createStatement();
    ResultSet rs = statement.executeQuery(sqlQuerry);
    int counter = 0;
    while (rs.next()) {
        System.out.println(rs.getString("FIRSTNAME") + ", " + rs.getString("LASTNAME") + ", " + rs.getInt("POSTS_COUNT"));
        counter++;
    }
    rs.close();
    statement.close();
    Assert.assertEquals(2, counter);
}}

