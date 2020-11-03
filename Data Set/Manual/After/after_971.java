public class Dummy{
public List<PatientBean> getRenewalNeedsPatients(long hcpMID) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM ( " + "SELECT DISTINCT patients.* FROM patients, declaredhcp, ovdiagnosis, officevisits, ovmedication" + " WHERE" + " declaredhcp.HCPID = ?" + " AND patients.MID = declaredhcp.PatientID" + " AND (ovdiagnosis.VisitID = officevisits.ID" + " AND officevisits.PatientID = declaredhcp.PatientID" + " AND ((ovdiagnosis.ICDCode >= ? AND ovdiagnosis.ICDCode < ?)" + " OR (ovdiagnosis.ICDCode >= ? AND ovdiagnosis.ICDCode < ?)" + " OR (ovdiagnosis.ICDCode >= ? AND ovdiagnosis.ICDCode < ?)))" + " UNION ALL" + " SELECT DISTINCT patients.* From patients, declaredhcp, ovdiagnosis, officevisits, ovmedication " + " WHERE" + " declaredhcp.HCPID = ?" + " AND patients.MID = declaredhcp.PatientID" + " AND (declaredhcp.PatientID = officevisits.PatientID" + " AND officevisits.ID = ovmedication.VisitID" + " AND ovmedication.EndDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY)))" + " AS final" + " GROUP BY final.MID HAVING COUNT(*) = 2" + " ORDER BY final.lastname ASC, final.firstname ASC")) {
        ps.setObject(1, hcpMID);
        ps.setObject(2, 250.0f);
        ps.setObject(3, 251.0f);
        ps.setObject(4, 493.0f);
        ps.setObject(5, 494.0f);
        ps.setObject(6, 390.0f);
        ps.setObject(7, 460.99f);
        ps.setObject(8, hcpMID);
        ResultSet rs = ps.executeQuery();
        List<PatientBean> loadlist = patientLoader.loadList(rs);
        rs.close();
        return loadlist;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

