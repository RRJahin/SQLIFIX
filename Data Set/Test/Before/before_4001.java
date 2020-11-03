class Dummy{
public void setPlayerTokens(Player player, int tokenAmount) {
    Connection c = null;
    Statement stmt = null;
    try {
        c = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        stmt = c.createStatement();
        String sql = "INSERT INTO eTokens (UUID, TOKENS) VALUES" + " ( '" + player.getUniqueId().toString() + "' , " + tokenAmount + ")";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
    } catch (Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
}}

