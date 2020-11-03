public class Dummy {
    @Override
        ic int updateUserInfo(String id, String pw,
        Connection con = null;    
                       
                       
                         
        Statement ps = null;
        String sql = "update u
     
 
        con = DbUtil.getConnection();
        ps = con.createStatement();
        result = ps.executeUpdate(sql);
    } finally {
        DbUtil.dbClose(con, ps);
    }
    return result;
}}

