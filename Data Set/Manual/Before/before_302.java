public class Dummy{
public List<PatientBean> getRenewalNeedsPatients(long hcpMID) throws DBException {
    try (Connection conn = factory.getConnection();
        Statement ps = conn.createStatement()) {
        ResultSet rs = ps.executeQuery("SELECT * FROM ( " + "SELECT DISTINCT patients.* FROM patients, declaredhcp, ovdiagnosis, officevisits, ovmedication" + " WHERE" + " declaredhcp.HCPID = "+hcpMID + " AND patients.MID = declaredhcp.PatientID" + " AND (ovdiagnosis.VisitID = officevisits.ID" + " AND officevisits.PatientID = declaredhcp.PatientID" + " AND ((ovdiagnosis.ICDCode >= "+ 250.0f+" AND ovdiagnosis.ICDCode < "+ 251.0f +")" + " OR (ovdiagnosis.ICDCode >= "+493.0f +" AND ovdiagnosis.ICDCode < "+494.0f +")" + " OR (ovdiagnosis.ICDCode >= "+390.0f +" AND ovdiagnosis.ICDCode < "+460.99f +")))" + " UNION ALL" + " SELECT DISTINCT patients.* From patients, declaredhcp, ovdiagnosis, officevisits, ovmedication " + " WHERE" + " declaredhcp.HCPID = "+hcpMID + " AND patients.MID = declaredhcp.PatientID" + " AND (declaredhcp.PatientID = officevisits.PatientID" + " AND officevisits.ID = ovmedication.VisitID" + " AND ovmedication.EndDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 7 DAY)))" + " AS final" + " GROUP BY final.MID HAVING COUNT(*) = 2" + " ORDER BY final.lastname ASC, final.firstname ASC");
        List<PatientBean> loadlist = patientLoader.loadList(rs);
        rs.close();
        return loadlist;
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

