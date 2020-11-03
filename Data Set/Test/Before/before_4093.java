class Dummy {
    @AfterClass
    public static void tearDownClass() throws SQLException {
        Statement prst2 = con.createStatement();
        prst2.execute("delete from Telefono where prefisso = '" + telefono.getPrefisso() + "' AND numero = '"
                + telefono.getNumero() + "';");
        persDAO.doDelete(pers);
        accDAO.doDelete(acc.getEmail());
        indDAO.doDelete(indirizzo2);
        con.commit();
        prst2.close();
        DriverManagerConnectionPool.releaseConnection(con);
        System.out.println("Database cleared");
    }
}
