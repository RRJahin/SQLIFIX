public class Dummy{
@AfterClass
public static void tearDownClass() throws SQLException {
    String queryDelete = "DELETE FROM Posizione WHERE etichetta = ? AND isil = ?";
    PreparedStatement prst1 = con.prepareStatement(queryDelete);
    prst1.setObject(1, posizione.getEtichetta());
    prst1.setObject(2, posizione.getBiblioteca().getIsil());
    prst1.execute();
    con.commit();
    prst1.close();
    DriverManagerConnectionPool.releaseConnection(con);
    System.out.println("Database cleared.");
}}

