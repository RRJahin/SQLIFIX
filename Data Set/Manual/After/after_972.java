public class Dummy{
@Override
public Patient getByID(long id) throws DBException {
    Patient ret = null;
    Connection conn = null;
    PreparedStatement pstring = null;
    ResultSet results = null;
    String stmt = "";
    stmt = "SELECT users.MID AS MID, users.Role AS Role, patients.firstName AS firstName, patients.lastName AS lastName FROM users INNER JOIN patients ON users.MID = patients.MID WHERE users.MID=?;";
    try {
        List<Patient> list = null;
        conn = ds.getConnection();
        pstring = conn.prepareStatement(stmt);
        pstring.setObject(1, Long.toString(id));
        results = pstring.executeQuery();
        list = loader.loadList(results);
        if (!list.isEmpty()) {
            ret = list.get(0);
        }
        return ret;
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
}}

