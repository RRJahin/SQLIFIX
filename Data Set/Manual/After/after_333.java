public class Dummy{
@AfterClass
public static void tearDownClass() throws SQLException {
    PreparedStatement prst2 = con.prepareStatement("delete from Persona where id = '" + id + "';");
    prst2.execute();
    con.commit();
    prst2.close();
    DriverManagerConnectionPool.releaseConnection(con);
    System.out.println("Database cleared");
}}

