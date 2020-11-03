class Dummy{
public int updateCode(OverrideReasonBean orc) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        return stmt.executeUpdate("UPDATE drugreactionoverridecodes SET Description = "+orc.getDescription()+" " + "WHERE Code = "+orc.getORCode());
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

