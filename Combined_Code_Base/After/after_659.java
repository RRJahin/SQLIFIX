class Dummy{
public void save(Country country) throws Exception {
    String SQL = "INSERT INTO COUNTRY VALUES (?, ?, ?)";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, country.getCountry_id());
        p.setObject(2, country.getCountry());
        p.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

