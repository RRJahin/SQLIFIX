class Dummy{
public OverrideReasonBean getORCode(String code) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery("SELECT * FROM drugreactionoverridecodes WHERE Code = "+code);
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

