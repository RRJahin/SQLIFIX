public class Dummy{
public boolean represents(long representer, long representee) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs = ps.executeQuery("SELECT * FROM representatives WHERE RepresenterMID="+representer+" AND RepresenteeMID="+representee);
        boolean doesRepresent = rs.next();
        rs.close();
        return doesRepresent;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

