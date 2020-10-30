public class Dummy{
public void update(Country country) throws Exception {
    String SQL = "UPDATE COUNTRY SET COUNTRY=?, LAST_UPDATE=? WHERE COUNTRY_ID=?";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, country.getCountry());
        p.setObject(2, new java.sql.Timestamp(new Date().getTime()));
        p.setObject(3, country.getCountry_id());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

