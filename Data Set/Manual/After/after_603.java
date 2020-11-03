class Dummy{
public int updateCode(OverrideReasonBean orc) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE drugreactionoverridecodes SET Description = ? " + "WHERE Code = ?")) {
        stmt.setObject(1, orc.getDescription());
        stmt.setObject(2, orc.getORCode());
        return stmt.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

