public class Dummy{
public Company getCompany() {
    String sql = "SELECT * FROM company " + "WHERE expiration_date IS null";
    PreparedStatement stat = null;
    ResultSet rs = null;
    Company company = null;
    try {
        stat = CONN.prepareStatement(sql);
        rs = stat.executeQuery();
        if (rs.next()) {
            company = new Company();
            company.setCompanyName(rs.getString("company_name"));
            company.setAddress(rs.getString("address"));
            company.setCity(rs.getString("city"));
            company.setSt(rs.getString("st"));
            company.setZip(rs.getString("zip"));
            company.setEmail(rs.getString("email"));
            company.setPhone(rs.getString("phone"));
        }
        lastError = null;
    } catch (SQLException sqle) {
        lastError = sqle.getMessage();
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqle) {
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException sqle) {
            }
        }
    }
    return company;
}}

