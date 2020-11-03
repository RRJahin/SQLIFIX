public class Dummy{
@Override
public int insertSelective(DateBean record) throws SQLException, Exception {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int count = 0;
    try {
        conn = ConnectionDB.getConnection("frankDS");
        String INSERT = "insert into TB_DATE values ( ?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(INSERT);
        if (record.getdYear4() != null) {
            ps.setObject(1, record.getdYear4());
        } else {
            throw new Exception("must inupt dYear4!");
        }
        if (record.getdDate() != null) {
            ps.setObject(2, new java.sql.Date(record.getdDate().getTime()));
        }
        if (record.getdTime() != null) {
            ps.setTime(3, new java.sql.Time(record.getdTime().getTime()));
        }
        if (record.getdDatetime() != null) {
            ps.setObject(4, new java.sql.Timestamp(record.getdDatetime().getTime()));
        }
        if (record.getdTimestamp() != null) {
            ps.setObject(5, new java.sql.Timestamp(record.getdTimestamp().getTime()));
        }
        count = ps.executeUpdate();
        System.out.println("insert count : " + count);
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    } finally {
        ConnectionDB.closeJDBCConnection(conn);
        ConnectionDB.closePreparedStatement(ps);
        ConnectionDB.closeResultSet(rs);
    }
    return count;
}}

