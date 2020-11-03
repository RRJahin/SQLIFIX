public class Dummy{
@AfterClass
public static void tearDownClass() throws SQLException {
    Statement prst = con.createStatement();
    prst.execute("DELETE FROM Prenotazione WHERE id = '" + i + "'");
    con.commit();
    prst.close();
    DriverManagerConnectionPool.releaseConnection(con);
    System.out.println("Database cleared");
}}

