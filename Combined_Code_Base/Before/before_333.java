public class Dummy{
@AfterClass
public static void tearDownClass() throws SQLException {
    Statement prst2 = con.createStatement();
    prst2.execute("delete from Persona where id = '" + id + "';");
    con.commit();
    prst2.close();
    DriverManagerConnectionPool.releaseConnection(con);
    System.out.println("Database cleared");
}}

