public class Dummy{
@AfterClass
public static void tearDownClass() throws SQLException {
    String queryDelete = "DELETE FROM Posizione WHERE etichetta = "+posizione.getEtichetta()+" AND isil = "+posizione.getBiblioteca().getIsil();
    Statement prst1 = con.createStatement();
    prst1.execute(queryDelete);
    con.commit();
    prst1.close();
    DriverManagerConnectionPool.releaseConnection(con);
    System.out.println("Database cleared.");
}}

