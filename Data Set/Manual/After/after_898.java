public class Dummy{
@Override
public OfficeVisit getByID(long id) throws DBException {
    OfficeVisit ret = null;
    Connection conn = null;
    PreparedStatement pstring = null;
    ResultSet results = null;
    List<OfficeVisit> visitList = null;
    try {
        conn = ds.getConnection();
        pstring = conn.prepareStatement("SELECT * FROM officeVisit WHERE visitID=?");
        pstring.setObject(1, id);
        results = pstring.executeQuery();
        visitList = ovLoader.loadList(results);
        if (visitList.size() > 0) {
            ret = visitList.get(0);
        }
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
    return ret;
}}

