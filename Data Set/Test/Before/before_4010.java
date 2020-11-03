class Dummy {
    public static int insertStatus(StatusBean u) {
        int status = 0;
        try {
            conn = ConnectionProvider.getCon();
            pst = conn.createStatement();
            status = pst.executeUpdate("insert into user_status_posts(username,user_status) values (" + 123 + ","
                    + u.getUser_status() + ")");
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
