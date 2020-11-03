class Dummy{
public void Update_Rechner(String rechnerNr, String ipadresse, String account, String passwort) throws NoAccessToDataBaseException {
    try {
        if (Connection != null) {
            Statement statement = Connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("UPDATE Rechner SET RechnerNr = '" + rechnerNr + "' , IPAdresse = '" + ipadresse + "', Account = '" + account + "',  Passwort = '" + passwort + "' WHERE RechnerNr = '" + rechnerNr + "';");
        } else
            throw new NoAccessToDataBaseException();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

