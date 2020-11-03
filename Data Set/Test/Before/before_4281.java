class Dummy{
@Override
public int delete(int id) {
    conn1 = UnitMysql.getConnection();
    int i = 0;
    try {
        String sqlDelete = "delete from users where id="+id;
        ps = conn1.createStatement();
        i = ps.executeUpdate(sqlDelete);
        if (i == 1) {
            return i;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        UnitMysql.Close(null, ps, conn1);
    }
    return i;
}}

