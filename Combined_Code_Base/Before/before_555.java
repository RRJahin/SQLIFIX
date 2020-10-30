public class Dummy{
public void save(Country country) throws Exception {
    String SQL = "INSERT INTO COUNTRY VALUES ("+country.getCountry_id()+","+ country.getCountry()+","+ new java.sql.Timestamp(new Date().getTime())+")";
    try {
        Statement p = connection.createStatement(SQL);
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

