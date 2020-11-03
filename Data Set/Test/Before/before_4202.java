class Dummy{
private void populate() {
    try {
        Statement st = ConnectionClass.conn.createStatement();
        String queryCheck = "SELECT user_being_followed FROM friend_relationship WHERE user = " + Integer.toString(userId);
        ResultSet rs = st.executeQuery(queryCheck);
        int columns = rs.getMetaData().getColumnCount();
        Vector<JButton> buttonVector = new Vector<JButton>();
        Vector<Integer> userIDVector = new Vector<Integer>();
        while (rs.next()) {
            JButton temp = new JButton(Integer.toString(rs.getInt(1)));
            temp.addActionListener(new ActionListenerProfile(rs.getInt(1), "friends"));
            userIDVector.add(rs.getInt(1));
            temp.setBackground(FirstPageGUI.green);
            temp.setForeground(FirstPageGUI.white);
            temp.setFont(FirstPageGUI.smallFont);
            temp.setBorder(new RoundedBorder());
            temp.setPreferredSize(new Dimension(dim.width / 4, dim.height / 20));
            temp.setOpaque(true);
            buttonVector.add(temp);
            temp.addActionListener(new ActionListenerProfile(rs.getInt(1), "friends"));
        }
        for (int i = 0; i < userIDVector.size(); i++) {
            queryCheck = "SELECT first_name, last_name FROM user_table WHERE iduser_table = " + userIDVector.get(i);
st = ConnectionClass.conn.createStatement();
            rs = st.executeQuery(queryCheck);
            columns = rs.getMetaData().getColumnCount();
            int index = 0;
            while (rs.next()) {
                String name = "";
                JButton temp = buttonVector.get(i);
                for (int j = 1; j <= columns; j++) {
                    name = name + rs.getString(j) + " ";
                }
                System.out.println("Name " + name);
                temp.setText(name);
                jpFollowing.add(temp);
            }
        }
        st.close();
    } catch (Exception e) {
    }
    try {
        Statement st = ConnectionClass.conn.createStatement();
        String queryCheck = "SELECT user FROM friend_relationship WHERE user_being_followed = " + Integer.toString(LoggedInDriverGUI.userID);
        ResultSet rs = st.executeQuery(queryCheck);
        int columns = rs.getMetaData().getColumnCount();
        System.out.println("after query");
        Vector<JButton> buttonVector = new Vector<JButton>();
        Vector<Integer> userIDVector = new Vector<Integer>();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                JButton temp = new JButton(Integer.toString(rs.getInt(1)));
                userIDVector.add(rs.getInt(1));
                temp.setBackground(FirstPageGUI.green);
                temp.setForeground(FirstPageGUI.white);
                temp.setFont(FirstPageGUI.smallFont);
                temp.setBorder(new RoundedBorder());
                temp.setPreferredSize(new Dimension(dim.width / 4, dim.height / 20));
                temp.setOpaque(true);
                buttonVector.add(temp);
            }
        }
        for (int i = 0; i < userIDVector.size(); i++) {
            queryCheck = "SELECT first_name, last_name FROM user_table WHERE iduser_table = " + Integer.toString(userIDVector.get(i));
st = ConnectionClass.conn.createStatement();
            rs = st.executeQuery(queryCheck);
            columns = rs.getMetaData().getColumnCount();
            int index = 0;
            while (rs.next()) {
                String name = "";
                JButton temp = buttonVector.get(i);
                for (int j = 1; j <= columns; j++) {
                    name = name + rs.getString(j) + " ";
                }
                System.out.println("Name " + name);
                temp.setText(name);
                jpFollowers.add(temp);
            }
        }
        for (int i = 0; i < userIDVector.size(); i++) {
            queryCheck = "SELECT user FROM friend_relationship WHERE user_being_followed = " + Integer.toString(userIDVector.get(i));
st = ConnectionClass.conn.createStatement();
            rs = st.executeQuery(queryCheck);
            columns = rs.getMetaData().getColumnCount();
            JButton button = buttonVector.get(i);
            if (rs.next()) {
                System.out.println("friends");
                button.addActionListener(new ActionListenerProfile(userIDVector.get(i), "friends"));
            } else {
                System.out.println("not friends");
                button.addActionListener(new ActionListenerProfile(userIDVector.get(i), "not friends"));
            }
        }
        st.close();
    } catch (Exception e) {
    }
    for (int i = 0; i < LoggedInDriverGUI.numFavoriteSongs; i++) {
        MusicModel MusicObject = LoggedInDriverGUI.favoriteSongNames.get(i);
        JButton temp2 = new JButton(MusicObject.getSongName());
        temp2.addActionListener(new ActionListenerPlayer(MusicObject));
        favoritesButtons.add(temp2);
    }
    try {
        Statement st = ConnectionClass.conn.createStatement();
        String queryCheck = "SELECT song_id FROM favorite_songs WHERE user_id = " + userId;
        ResultSet rs = st.executeQuery(queryCheck);
        Vector<Integer> songIds = new Vector<Integer>();
        while (rs.next()) {
            songIds.add(rs.getInt(1));
        }
        for (int i = 0; i < songIds.size(); i++) {
            queryCheck = "SELECT song_name from music_table where idmusic_table = " + songIds.get(i);
st = ConnectionClass.conn.createStatement();
            rs = st.executeQuery(queryCheck);
            while (rs.next()) {
                JButton temp = new JButton("");
                temp.setText(rs.getString(1));
                MusicModel model = LoggedInDriverGUI.sharedMusicLibrary.getMusicModelMap().get(rs.getString(1));
                temp.addActionListener(new ActionListenerPlayer(model));
                temp.setBackground(FirstPageGUI.green);
                temp.setForeground(FirstPageGUI.white);
                temp.setFont(FirstPageGUI.smallFont);
                temp.setBorder(new RoundedBorder());
                temp.setPreferredSize(new Dimension(dim.width / 4, dim.height / 20));
                temp.setOpaque(true);
                jpFavorites.add(temp);
            }
        }
    } catch (SQLException e1) {
        e1.printStackTrace();
    }
}}

