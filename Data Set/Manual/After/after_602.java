class Dummy{
public boolean addORCode(OverrideReasonBean orc) throws DBException, ITrustException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO drugreactionoverridecodes (Code, Description) " + "VALUES (?,?)")) {
        stmt.setObject(1, orc.getORCode());
        stmt.setObject(2, orc.getDescription());
        return stmt.executeUpdate() == 1;
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062)
            throw new ITrustException("Error: Code already exists.");
        throw new DBException(e);
    }
}}

