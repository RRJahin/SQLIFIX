class Dummy {
    @Override
    protected String doInBackground(String... params) {
        String retval = "";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            retval = e.toString();
        }
        String url = "jdbc:postgresql://10.0.2.2/postgres?user=postgres&password=1234";
        Connection conn;
        try {
            DriverManager.setLoginTimeout(5);
            conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            String sql;
            sql = "SELECT * FROM deliveryTable WHERE id = " + id_input + ";";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                retval = rs.getString("receiver");
            }
            rs.close();
            st.close();
            conn.close();
            if (retval.equals("")) {
                return "Invalid delivery ID";
            }
            if (!retval.equals(mastername)) {
                return "You cannot rate this delivery because you are not the receiver";
            }
            int rows;
            try {
                DriverManager.setLoginTimeout(5);
                conn = DriverManager.getConnection(url);
                sql = "UPDATE deliveryTable SET rate = " + score + " WHERE id = " + id_input + ";";
                PreparedStatement st2 = conn.prepareStatement(sql);
st2 = conn.createStatement();
                rows = st2.executeUpdate();
                st2.close();
                conn.close();
                return ("Rated successfully");
            } catch (SQLException e) {
                e.printStackTrace();
                return "Database error! Make sure to have valid connections";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            retval = e.toString();
            return retval;
        }
    }
}
