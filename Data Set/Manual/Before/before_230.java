public class Dummy{
public LocalDate getPatientDOB(final Long patientMID) {
    Connection conn = null;
    Statement pstring = null;
    ResultSet results = null;
    java.sql.Date patientDOB = null;
    try {
        conn = ds.getConnection();
        pstring = conn.createStatement();
        results = pstring.executeQuery("SELECT DateOfBirth FROM patients WHERE MID="+patientMID);
        if (!results.next()) {
            return null;
        }
        patientDOB = results.getDate("DateOfBirth");
    } catch (SQLException e) {
        return null;
    } finally {
        try {
            if (results != null) {
                results.close();
            }
        } catch (SQLException e) {
            return null;
        } finally {
            DBUtil.closeConnection(conn, pstring);
        }
    }
    if (patientDOB == null) {
        return null;
    }
    return patientDOB.toLocalDate();
}}

