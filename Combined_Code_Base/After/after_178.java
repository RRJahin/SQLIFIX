public class Dummy {
    public List<SuborderDetails> getSuborderDetailsBySuborder(String suborder) {
        List<SuborderDetails> suboDetails = null;
        try {
            connection = DBManager.getLocalConnection();
            queryString = "SELECT * from shipping.ica_couriers where subo in (?)";
            statement = (Statement) connection.prepareStatement(queryString);
            statement.setObject(1, suborder);
            suboDetails = new ArrayList<SuborderDetails>();
            resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    SuborderDetails sd = new SuborderDetails();
                    sd.setSupc(resultSet.getString("supc"));
                    sd.setSuborderCode(resultSet.getString("subo"));
                    sd.setVendorCode(resultSet.getString("VENDOR_CODE"));
                    sd.setDestinationPincode(resultSet.getString("dest_pincode"));
                    sd.setDels(resultSet.getString("DELS"));
                    sd.setPulc(resultSet.getString("PULC"));
                    sd.setPuls(resultSet.getString("PULS"));
                    sd.setDelc(resultSet.getString("DELC"));
                    sd.setPrice(resultSet.getString("PRICE"));
                    sd.setWeight(resultSet.getString("WEIGHT"));
                    sd.setFm(resultSet.getString("FM"));
                    sd.setWarehouseCode(resultSet.getString("WAREHOUSE_CODE"));
                    sd.setProductName(resultSet.getString("product_name"));
                    sd.setBrand(resultSet.getString("BRAND"));
                    sd.setCategory(resultSet.getString("CATEGORY"));
                    sd.setCategoryUrl(resultSet.getString("CATEGORY_URL"));
                    sd.setMultipart(resultSet.getString("MULTIPART"));
                    sd.setDgType(resultSet.getString("DANGEROUSGOODSTYPE"));
                    sd.setShippingMode(resultSet.getString("SHIPPING_MODE"));
                    sd.setShippingMode(resultSet.getString("SHIPPING_METHOD"));
                    sd.setStdCourier(resultSet.getString("std_courier_t"));
                    sd.setCodCourier(resultSet.getString("cod_courier_t"));
                    sd.setReason(resultSet.getString("reason"));
                    sd.setSuboCreated(resultSet.getString("subo_created"));
                    sd.setCreated(resultSet.getString("created"));
                    sd.setOfffset(resultSet.getString("offset"));
                    suboDetails.add(sd);
                }
            }
            resultSet.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return suboDetails;
    }
}
