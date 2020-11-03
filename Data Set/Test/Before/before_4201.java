class Dummy{
public void make() {
    try {
        s = new Socket("104.236.176.180", 5000);
        oos = new ObjectOutputStream(s.getOutputStream());
    } catch (Exception e) {
        e.printStackTrace();
    }
    try {
        String sql = "select profile_picture from user_table where iduser_table=?";
        PreparedStatement ps = (PreparedStatement) ConnectionClass.conn.prepareStatement(sql);
        ps.setInt(1, userId);
ps = conn.createStatement();
        ResultSet RS = ps.executeQuery();
        int columns = RS.getMetaData().getColumnCount();
        String finalPathToPicture = null;
        while (RS.next()) {
            for (int i = 1; i <= columns; i++) {
                finalPathToPicture = RS.getString(i);
            }
        }
        if (!finalPathToPicture.equals(null)) {
            URL imageurl = new URL(finalPathToPicture);
            BufferedImage img = ImageIO.read(imageurl);
            ImageIcon newIcon2 = new ImageIcon(img);
            System.out.println(finalPathToPicture + "GOOOOOOOOZE");
            Image img2 = newIcon2.getImage().getScaledInstance(dim.width / 2, dim.height / 4, Image.SCALE_SMOOTH);
            profilePic = new ImageIcon(img2);
        } else {
            ImageIcon newIcon2 = new ImageIcon("data/headphone_default.jpg");
            Image img2 = newIcon2.getImage().getScaledInstance(dim.width / 2, dim.height / 4, Image.SCALE_SMOOTH);
            profilePic = new ImageIcon(img2);
        }
    } catch (Exception e4) {
        ImageIcon newIcon2 = new ImageIcon("data/headphone_default.jpg");
        Image img2 = newIcon2.getImage().getScaledInstance(dim.width / 2, dim.height / 4, Image.SCALE_SMOOTH);
        profilePic = new ImageIcon(img2);
    }
    pictureButton.setIcon(profilePic);
    picturePic.setIcon(profilePic);
    try {
        Statement stat = (Statement) ConnectionClass.conn.createStatement();
        String sql = "Select * from user_table Where iduser_table='" + userId + "'";
        ResultSet rs = stat.executeQuery(sql);
        if (rs.next()) {
            name.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
            email.setText(rs.getString("email"));
            System.out.println(rs.getString("bio"));
            bio.setText(rs.getString("bio"));
            username = rs.getString("username");
            rs.close();
            stat.close();
        } else {
            System.out.println("something wrong");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    populate();
}}

