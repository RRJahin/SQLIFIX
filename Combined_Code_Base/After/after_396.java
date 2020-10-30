public class Dummy{
@Override
public PlayerPO getPlayerByName(String name) {
    PlayerPO player = new PlayerPO();
    String sql = "select name,number,position,height,weight,birth,age,exp,school,actionimgpath,portraitimgpath,seasonsp from nba.players where name=?";
    Connection conn = DBUtil.open();
    try {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setObject(1, name);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            player.setName(rs.getString("name"));
            player.setNumber(rs.getString("number"));
            player.setPosition(rs.getString("position"));
            player.setHeight(rs.getString("height"));
            player.setWeight(rs.getString("weight"));
            player.setBirth(rs.getString("birth"));
            player.setAge(rs.getInt("age"));
            player.setExp(rs.getInt("exp"));
            player.setSchool(rs.getString("school"));
            player.setActionImgPath(rs.getString("actionimgpath"));
            player.setPortraitImgPath(rs.getString("portraitimgpath"));
            if ((rs.getString("seasonsp") != null) && !rs.getString("seasonsp").equals("")) {
                String seasonSpListText = rs.getString("seasonsp");
                ArrayList<SinglePerformance> spList = new ArrayList<SinglePerformance>();
                String[] splited = seasonSpListText.split("\\$");
                for (int i = 0; i < splited.length; i++) {
                    spList.add(SinglePerformance.makeSP(splited[i]));
                }
                player.setSeasonSinglePerformance(spList);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DBUtil.close(conn);
    }
    return player;
}}

