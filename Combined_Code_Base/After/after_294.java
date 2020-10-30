public class Dummy{
public boolean represents(long representer, long representee) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM representatives WHERE RepresenterMID=? AND RepresenteeMID=?")) {
        ps.setObject(1, representer);
        ps.setObject(2, representee);
        ResultSet rs = ps.executeQuery();
        boolean doesRepresent = rs.next();
        rs.close();
        return doesRepresent;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

