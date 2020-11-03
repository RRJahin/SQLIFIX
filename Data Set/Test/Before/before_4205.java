class Dummy{
public Rechner GetRechner_by_RechnerNr(String rechnerNr) throws NoAccessToDataBaseException {
    try {
        if (Connection != null) {
            Statement statement = Connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet result = statement.executeQuery("SELECT * FROM Rechner WHERE RechnerNr = '" + rechnerNr + "';");
            Rechner rechner = new Rechner();
            while (result.next()) {
                String RechnerNr = result.getString("RechnerNr");
                String ipadresse = result.getString("IPAdresse");
                String account = result.getString("Account");
                String passwort = result.getString("Passwort");
                rechner.setValues(RechnerNr, ipadresse, account, passwort);
            }
            return rechner;
        } else
            throw new NoAccessToDataBaseException();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new NoAccessToDataBaseException();
    }
}}

