class Dummy{
private boolean validasi(String judul) {
    try {
        stt = con.createStatement();
        String sql = "SELECT * FROM buku where judul='" + judul + "'";
        rss = stt.executeQuery(sql);
        if (rss.next())
            return true;
        else
            return false;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return false;
    }
}}

