public class Dummy{
public void delete(Country country) throws Exception {
    String SQL = "DELETE FROM COUNTRY WHERE COUNTRY_ID = ?";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, country.getCountry_id());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

