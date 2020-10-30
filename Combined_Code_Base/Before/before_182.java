public class Dummy{
@Override
public int insert(DateBean record) throws SQLException, Exception {
    Connection conn = null;
    Statement ps = null;
    ResultSet rs = null;
    int count = 0;
    try {
        conn = ConnectionDB.getConnection("frankDS");
        String INSERT = "insert into TB_DATE values ( "+record.getdYear4()+","+ new java.sql.Date(record.getdDate().getTime())+","+new java.sql.Time(record.getdTime().getTime())+","+ new java.sql.Timestamp(record.getdDatetime().getTime())+","+ new java.sql.Timestamp(record.getdTimestamp().getTime())+")";
        ps = conn.createStatement();
        if (record.getdYear4() != null) {
        } else {
            throw new Exception("must inupt dYear4!");
        }
        count = ps.executeUpdate(INSERT);
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

