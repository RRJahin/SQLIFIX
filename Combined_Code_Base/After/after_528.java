public class Dummy{
public void deleteUserDao(String del_Account) {
    Connection con = null;
    PreparedStatement statement = null;
    try {
        con = JdbcUtil.jdbcUtil();
        String sql = "update atm_user set state = 2 where account = '?';";
        statement = con.prepareStatement(sql);
        statement.setObject(1,del_Account);
        statement.executeUpdate();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

