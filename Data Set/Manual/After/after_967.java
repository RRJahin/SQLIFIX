public class Dummy{
public boolean removeRepresentative(long representer, long representee) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM representatives WHERE RepresenterMID=? AND RepresenteeMID=?")) {
        ps.setObject(1, representer);
        ps.setObject(2, representee);
        boolean successfullyDeleted = ps.executeUpdate() == 1;
        return successfullyDeleted;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

