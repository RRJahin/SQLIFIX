public class Dummy{
public void addUserDao() {
    Connection con = null;
    Statement statement = null;
    try {
        con = JdbcUtil.jdbcUtil();
        String date = FormatUtil.formatUtil("yyyy-MM-dd", user.getBirthday());
        String sql = "insert into atm_user" + "(id,userName,idCardNumber,gender,birthday,address,balance,account, password,type,state,remark)" + "value ("+user.getId()+","+user.getUserName()+","+user.getIdCardNumber()+","+user.getGender()+","+date+","+user.getAddress() +","+user.getBalance()+","+user.getAccount()+","+user.getPassword()+","+user.getType()+","+user.getState()+","+user.getRemark()+")";
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

