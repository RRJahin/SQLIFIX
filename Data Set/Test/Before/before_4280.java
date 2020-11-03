class Dummy{
@Override
public int update(Tb_User t) {
    conn1 = UnitMysql.getConnection();
    int i = 0;
    try {
        String sqlUpdate = "update users set name="+t.getName()+", password ="+t.getPassword()+" where id="+t.getId();
        ps = conn1.createStatement();
        i = ps.executeUpdate(sqlUpdate);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        UnitMysql.Close(null, ps, conn1);
    }
    return i;
}}

