public class Dummy{
@Override
public List<OfficeVisit> getVisitsForPatient(Long patientID) throws DBException {
    Connection conn = null;
    PreparedStatement pstring = null;
    ResultSet results = null;
    if (ValidationFormat.NPMID.getRegex().matcher(Long.toString(patientID)).matches()) {
        try {
            conn = ds.getConnection();
            pstring = conn.prepareStatement("SELECT * FROM officeVisit WHERE patientMID=?");
            pstring.setObject(1, patientID);
            results = pstring.executeQuery();
            final List<OfficeVisit> visitList = ovLoader.loadList(results);
            return visitList;
        } catch (SQLException e) {
            throw new DBException(e);
        } finally {
            try {
                if (results != null) {
                    results.close();
                }
            } catch (SQLException e) {
                throw new DBException(e);
            } finally {
                DBUtil.closeConnection(conn, pstring);
            }
        }
    } else {
        return null;
    }
}}

