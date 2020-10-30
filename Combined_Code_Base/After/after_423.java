public class Dummy{
@AfterClass
public static void tearDownClass() throws SQLException {
    PreparedStatement prst = con.prepareStatement("DELETE FROM Prenotazione WHERE id = '?'");
    prst.setObject(1,i);
    prst.execute();
    con.commit();
    prst.close();
    DriverManagerConnectionPool.releaseConnection(con);
    System.out.println("Database cleared");
}}

