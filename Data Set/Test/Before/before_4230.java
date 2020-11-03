class Dummy{
public boolean existeNickname(String nickname) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs = s.executeQuery("SELECT PSEUDONIMO FROM maestro WHERE PSEUDONIMO ='" + nickname + "'");
    return rs.next();
}}

