class Dummy{
@Override
public Tb_User queryDataById(int id) {
    conn1 = UnitMysql.getConnection();
    String sql = "select * from users where id="+id;
    Tb_User user = null;
    if (id > 0) {
        try {
            ps = conn1.createStatement();
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                user = new Tb_User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday"));
                user.setSex(rs.getBoolean("sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UnitMysql.Close(null, ps, conn1);
        }
    }
    return user;
}}

