public class Dummy{
public List<PersonnelBean> getDeclaredHCPs(long pid) throws DBException {
    if (pid == 0L) {
        throw new DBException(new SQLException("pid cannot be 0"));
    }
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM declaredhcp, personnel " + "WHERE PatientID=? AND personnel.MID=declaredhcp.HCPID")) {
        ps.setObject(1, pid);
        ResultSet rs = ps.executeQuery();
        List<PersonnelBean> loadlist = personnelLoader.loadList(rs);
        rs.close();
        return loadlist;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

