class Dummy{
public boolean addORCode(OverrideReasonBean orc) throws DBException, ITrustException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        return stmt.executeUpdate("INSERT INTO drugreactionoverridecodes (Code, Description) " + "VALUES ("+orc.getORCode()+","orc.getDescription()+")") == 1;
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062)
            throw new ITrustException("Error: Code already exists.");
        throw new DBException(e);
    }
}}

