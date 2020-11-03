class Dummy{
public void DeleteFrom_Rechner(String rechnerNr) throws NoAccessToDataBaseException {
    try {
        if (Connection != null) {
            Statement statement = Connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("DELETE FROM RECHNER WHERE RechnerNr = '" + rechnerNr + "';");
        } else
            throw new NoAccessToDataBaseException();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

