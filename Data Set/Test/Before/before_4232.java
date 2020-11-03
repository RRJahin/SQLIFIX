class Dummy{
public String regUser(String email, String pass, String nick, int tipo) throws SQLException {
    if (existeNickname(nick)) {
        return "Pseudonimo ya existe";
    }
    if (existeEmail(email)) {
        return "Email ya existe";
    }
    ResultSet rs = null;
    try {
        Statement stmt = connection.createStatement();
        int inserted = stmt.executeUpdate("insert into maestro values(1,'" + email + "','" + pass + "','" + nick + "'," + tipo + ",0,0,0)");
        connection.commit();
        stmt.close();
    } catch (SQLException ex) {
        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "Ok";
}}

