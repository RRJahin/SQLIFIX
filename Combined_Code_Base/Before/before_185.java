public class Dummy{
@Override
public int updateByPrimaryKeySelective(DateBean record) throws SQLException, Exception {
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    int count = 0;
    try {
        conn = ConnectionDB.getConnection("frankDS");
        String UPDATE = "update TB_DATE set d_date = +"+new java.sql.Date(record.getdDate().getTime())+", d_time = "+new java.sql.Time(record.getdTime().getTime())+", d_datetime = "+new java.sql.Timestamp(record.getdDatetime().getTime())+", d_timestamp = "+new java.sql.Timestamp(record.getdTimestamp().getTime()) + "where d_year_4 = "+record.getdYear4();
        ps = conn.createStatement();
        if (record.getdYear4() != null) {
        } else {
            throw new Exception("must inupt dYear4!");
        }
        if (record.getdDate() != null) {
        }
        if (record.getdTime() != null) {
        }
        if (record.getdDatetime() != null) {
        }
        if (record.getdTimestamp() != null) {
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

