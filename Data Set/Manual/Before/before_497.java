public class Dummy{
public String getAgentUserName(String user, String pass) throws SQLException {
    String str = "Approved";
    Statement ps = con.createStatement();
    ResultSet res = ps.executeQuery("select * from agent_details where agn_id="+user+" and password="+pass+" and approval="+str+" ");
    boolean b = res.next();
    if (b) {
        return user;
    } else {
        return null;
    }
}}

