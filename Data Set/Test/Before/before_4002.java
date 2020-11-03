class Dummy{
public int getTokenAmount(Player player) {
    Connection c = null;
    Statement stmt = null;
    int tokens = -1;
    try {
        c = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        c.setAutoCommit(false);
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM eTokens WHERE UUID='" + player.getUniqueId().toString() + "';");
        while (rs.next()) {
            tokens = rs.getInt("TOKENS");
        }
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
    return tokens;
}}

