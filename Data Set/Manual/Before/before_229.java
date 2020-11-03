public class Dummy{
@Override
public OfficeVisit getByID(long id) throws DBException {
    OfficeVisit ret = null;
    Connection conn = null;
    Statement pstring = null;
    ResultSet results = null;
    List<OfficeVisit> visitList = null;
    try {
        conn = ds.getConnection();
        pstring = conn.createStatement();
        results = pstring.executeQuery("SELECT * FROM officeVisit WHERE visitID="+id);
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

