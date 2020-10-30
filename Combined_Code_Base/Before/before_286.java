public class Dummy{
public List<PersonnelBean> getDeclaredHCPs(long pid) throws DBException {
    if (pid == 0L) {
        throw new DBException(new SQLException("pid cannot be 0"));
    }
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs = ps.executeQuery("SELECT * FROM declaredhcp, personnel " + "WHERE PatientID="+pid+" AND personnel.MID=declaredhcp.HCPID");
        List<PersonnelBean> loadlist = personnelLoader.loadList(rs);
        rs.close();
        return loadlist;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

