public class Dummy{
public String getAgentUserName(String user, String pass) throws SQLException {
    String str = "Approved";
    PreparedStatement ps = con.prepareStatement("select * from agent_details where agn_id=? and password=? and approval=? ");
    ps.setObject(1, user);
    ps.setObject(2, pass);
    ps.setObject(3, str);
    ResultSet res = ps.executeQuery();
    boolean b = res.next();
    if (b) {
        return user;
    } else {
        return null;
    }
}}

