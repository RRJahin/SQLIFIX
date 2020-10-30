public class Dummy{
public boolean checkPatientExists(long pid) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs = ps.executeQuery("SELECT * FROM patients WHERE MID="+pid);
        boolean exists = rs.next();
        rs.close();
        return exists;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

