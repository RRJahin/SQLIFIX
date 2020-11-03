class Dummy{
public void InsertInto_Rechner(String rechnerNr, String ipadresse, String account, String passwort) throws NoAccessToDataBaseException {
    try {
        if (Connection != null) {
            Statement statement = Connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO Rechner (RechnerNr, IPAdresse, Account, Passwort) VALUES('" + rechnerNr + "', '" + ipadresse + "', '" + account + "', '" + passwort + "');");
        } else
            throw new NoAccessToDataBaseException();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

