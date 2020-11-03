class Dummy{
public boolean reportInteraction(String firstDrug, String secondDrug, String description) throws ITrustException {
    if (firstDrug.equals(secondDrug))
        throw new ITrustException("Drug cannot interact with itself.");
    List<DrugInteractionBean> currentIntsDrug2 = getInteractions(secondDrug);
    for (DrugInteractionBean dib : currentIntsDrug2) {
        if (dib.getSecondDrug().equals(firstDrug)) {
            throw new ITrustException("Error: Interaction between these drugs already exists.");
        }
    }
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        boolean successfullyAdded = stmt.executeUpdate("INSERT INTO druginteractions (FirstDrug, SecondDrug, Description) " + "VALUES ("+firstDrug+","+secondDrug+","+description+")") == 1;
        return successfullyAdded;
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062)
            throw new ITrustException("Error: Interaction between these drugs already exists.");
        throw new DBException(e);
    }
}}

