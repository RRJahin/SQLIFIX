public class Dummy{
@Override
public int updateByPrimaryKeySelective(DateBean record) throws SQLException, Exception {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int count = 0;
    try {
        conn = ConnectionDB.getConnection("frankDS");
        String UPDATE = "update TB_DATE set d_date = ?, d_time = ?, d_datetime = ?, d_timestamp = ?" + "where d_year_4 = ?";
        ps = conn.prepareStatement(UPDATE);
        if (record.getdYear4() != null) {
            ps.setObject(5, record.getdYear4());
        } else {
            throw new Exception("must inupt dYear4!");
        }
        if (record.getdDate() != null) {
            ps.setObject(1, new java.sql.Date(record.getdDate().getTime()));
        }
        if (record.getdTime() != null) {
            ps.setTime(2, new java.sql.Time(record.getdTime().getTime()));
        }
        if (record.getdDatetime() != null) {
            ps.setObject(3, new java.sql.Timestamp(record.getdDatetime().getTime()));
        }
        if (record.getdTimestamp() != null) {
            ps.setObject(4, new java.sql.Timestamp(record.getdTimestamp().getTime()));
        }
        count = ps.executeUpdate();
        System.out.println("update count : " + count);
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

