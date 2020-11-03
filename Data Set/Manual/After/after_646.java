class Dummy{
public boolean insert(UserPresence presence) {
    try {
        int id = presence.getUserId();
        long joined = presence.getJoinedDate().getTime();
        long leaved = presence.getLeavedDate().getTime();
        
        String query = "INSERT INTO ? (id, joined, leaved)" + " VALUES(?, ?, ?)";
    PreparedStatement statement = connection.prepareStatement(query);
        statement.setQueryTimeout(30);
        statement.setobject(1,currentTable );
        statement.setobject(2,id);
        statement.setobject(3,joined );
        statement.setobject(4,leaved);
        int nRet = statement.executeUpdate();
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

