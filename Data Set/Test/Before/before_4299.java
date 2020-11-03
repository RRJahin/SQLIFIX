class Dummy{
@AfterClass
public static void tearDownClass() throws SQLException {
    Statement prst2 = con.createStatement();
    Statement prst = con.createStatement();
    prst2.execute("delete from Indirizzo where via = '" + indirizzo.getVia() + "' AND citta = '" + indirizzo.getCitta() + "' AND civico = '" + indirizzo.getCivico() + "';");
    prst.execute("delete from Indirizzo where via = '" + nuovoIndirizzo.getVia() + "' AND citta = '" + nuovoIndirizzo.getCitta() + "' AND civico = '" + nuovoIndirizzo.getCivico() + "';");
    con.commit();
    prst2.close();
    DriverManagerConnectionPool.releaseConnection(con);
    System.out.println("Database cleared");
}}

