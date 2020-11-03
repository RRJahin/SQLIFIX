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
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO druginteractions (FirstDrug, SecondDrug, Description) " + "VALUES (?,?,?)")) {
        stmt.setObject(1, firstDrug);
        stmt.setObject(2, secondDrug);
        stmt.setObject(3, description);
        boolean successfullyAdded = stmt.executeUpdate() == 1;
        return successfullyAdded;
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062)
            throw new ITrustException("Error: Interaction between these drugs already exists.");
        throw new DBException(e);
    }
}}

