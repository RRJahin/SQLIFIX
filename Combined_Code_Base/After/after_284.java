public class Dummy{
public void editPatient(PatientBean p, long hcpid) throws DBException {
    try (Connection conn = factory.getConnection();
        PreparedStatement ps = patientLoader.loadParameters(conn.prepareStatement("UPDATE patients SET firstName=?,lastName=?,email=?," + "address1=?,address2=?,city=?,state=?,zip=?,phone=?," + "eName=?,ePhone=?,iCName=?,iCAddress1=?,iCAddress2=?,iCCity=?," + "ICState=?,iCZip=?,iCPhone=?,iCID=?,DateOfBirth=?," + "DateOfDeath=?,CauseOfDeath=?,MotherMID=?,FatherMID=?," + "BloodType=?,Ethnicity=?,Gender=?,TopicalNotes=?, CreditCardType=?, CreditCardNumber=?, " + "DirectionsToHome=?, Religion=?, Language=?, SpiritualPractices=?, " + "AlternateName=?, DateOfDeactivation=? WHERE MID=?"), p)) {
        ps.setObject(1, p.getMID());
        ps.executeUpdate();
    } catch (SQLException e) {
        throw new DBException(e);
    }
}}

