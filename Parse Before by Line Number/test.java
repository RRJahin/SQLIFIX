class dummy {
    "DELETE FROM COUNTRY WHERE COUNTRY_ID = "+country.getCountry_id();
    Statement p = connection.createStatement();p.execute(SQL);
}