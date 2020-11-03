public class Dummy{
@Override
public void add(PlayerPO player) {
    String sql = "insert into nba.players(name,number,position,height,weight,birth,age,exp,school,actionimgpath,portraitimgpath)values(?,?,?,?,?,?,?,?,?,?,?)";
    Connection conn = DBUtil.open();
    try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setObject(1, player.getName());
        pstmt.setObject(2, player.getNumber());
        pstmt.setObject(3, player.getPosition());
        pstmt.setObject(4, player.getHeight());
        pstmt.setObject(5, player.getWeight());
        pstmt.setObject(6, player.getBirth());
        pstmt.setObject(7, player.getAge());
        pstmt.setObject(8, player.getExp());
        pstmt.setObject(9, player.getSchool());
        pstmt.setObject(10, player.getActionImgPath());
        pstmt.setObject(11, player.getPortraitImgPath());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtil.close(conn);
    }
}}

