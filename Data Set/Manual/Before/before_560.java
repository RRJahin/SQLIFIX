public class Dummy{
public void update(Country country) throws Exception {
    String SQL = "UPDATE COUNTRY SET COUNTRY="+country.getCountry()+", LAST_UPDATE="+country.getCountry() +"WHERE COUNTRY_ID="+new java.sql.Timestamp(new Date().getTime());
    try {
        Statement p = connection.createStatement();
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

