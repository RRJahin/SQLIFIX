public class Dummy{
public void addUserDao() {
    Connection con = null;
    PreparedStatement statement = null;
    try {
        con = JdbcUtil.jdbcUtil();
        String sql = "insert into atm_user" + "(id,userName,idCardNumber,gender,birthday,address,balance,account, password,type,state,remark)" + "value (?,?,?,?,?,?,?,?,?,?,?,?)";
        statement = con.prepareStatement(sql);
        String date = FormatUtil.formatUtil("yyyy-MM-dd", user.getBirthday());
        statement.setObject(1, user.getId());
        statement.setObject(2, user.getUserName());
        statement.setObject(3, user.getIdCardNumber());
        statement.setObject(4, user.getGender());
        statement.setObject(5, date);
        statement.setObject(6, user.getAddress());
        statement.setObject(7, user.getBalance());
        statement.setObject(8, user.getAccount());
        statement.setObject(9, user.getPassword());
        statement.setObject(10, user.getType());
        statement.setObject(11, user.getState());
        statement.setObject(12, user.getRemark());
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

