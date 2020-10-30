public class Dummy{
public boolean checkPatientExists(long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM patients WHERE MID=?")) {
        ps.setObject(1, pid);
        ResultSet rs = ps.executeQuery();
        boolean exists = rs.next();
        rs.close();
        return exists;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

