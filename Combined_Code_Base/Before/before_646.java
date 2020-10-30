class Dummy{
public boolean insert(UserPresence presence) {
    try {
        int id = presence.getUserId();
        long joined = presence.getJoinedDate().getTime();
        long leaved = presence.getLeavedDate().getTime();
        ;
        String query = "INSERT INTO " + currentTable + "(id, joined, leaved)" + " VALUES(" + id + ", " + joined + ", " + leaved + ")";
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        
        int nRet = statement.executeUpdate(query);
        if (nRet > 0) {
            return true;
        } else {
            System.out.println("Insert failed");
            return false;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}}

