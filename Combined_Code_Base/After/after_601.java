class Dummy{
public OverrideReasonBean getORCode(String code) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM drugreactionoverridecodes WHERE Code = ?")) {
        stmt.setObject(1, code);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            OverrideReasonBean result = orcLoader.loadSingle(rs);
            rs.close();
            return result;
        }
        rs.close();
        return null;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

