public class Dummy{
public List<Service> getServices() {
    List<Service> services = new ArrayList<>();
    String sql = "SELECT * FROM services " + "WHERE expiration_date IS null";
    Statement stat = null;
    ResultSet rs = null;
    try {
        stat = CONN.createStatement();
        rs = stat.executeQuery(sql);
        while (rs.next()) {
            Service service = new Service();
            service.setServiceGroup(rs.getString("service_group"));
            service.setServiceGroupDescription(rs.getString("service_group_description"));
            service.setServiceType(rs.getString("service_type"));
            service.setServiceTypeDescription(rs.getString("service_type_description"));
            services.add(service);
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
    return services;
}}

