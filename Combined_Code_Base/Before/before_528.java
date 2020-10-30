public class Dummy{
public void deleteUserDao(String del_Account) {
    Connection con = null;
    Statement statement = null;
    try {
        con = JdbcUtil.jdbcUtil();
        String sql = "update atm_user set state = 2 where account = '" + del_Account + "';";
        statement = con.createStatement();
        statement.executeUpdate(sql);
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

