public class Dummy{
@Override
public void add(PlayerPO player) {
    String sql = "insert into nba.players(name,number,position,height,weight,birth,age,exp,school,actionimgpath,portraitimgpath)values("+player.getName()+","+player.getNumber()+","+player.getPosition()+","+player.getHeight()+","+player.getWeight()+","+player.getBirth()+","+player.getAge()+","+player.getExp()+","+player.getSchool()+","+player.getActionImgPath()+","+player.getPortraitImgPath()+")";
    Connection conn = DBUtil.open();
    try {
        Statement pstmt = conn.createStatement();
        pstmt.executeUpdate(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtil.close(conn);
    }
}}

