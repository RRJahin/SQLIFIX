class Dummy{
public boolean existeEmail(String email) throws SQLException {
    Statement s = connection.createStatement();
    ResultSet rs = s.executeQuery("SELECT EMAIL FROM maestro WHERE EMAIL ='" + email + "'");
    return rs.next();
}}

