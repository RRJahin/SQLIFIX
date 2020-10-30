public class Dummy{
public boolean removeRepresentative(long representer, long representee) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        boolean successfullyDeleted = ps.executeUpdate("DELETE FROM representatives WHERE RepresenterMID="+representer+" AND RepresenteeMID="+representee) == 1;
        return successfullyDeleted;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

