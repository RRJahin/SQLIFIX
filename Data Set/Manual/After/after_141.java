public class Dummy{
public void createServices(ServiceOrder serviceOrder) {
    String sql = "INSERT INTO service_order " + "(memberid, service_group, service_type_mow, service_type_edge, service_type_rake, " + "instruction, need_by_date, create_user_name, create_date, change_user_name, change_date)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement pstat = null;
    try {
        pstat = CONN.prepareStatement(sql);
        pstat.setObject(1, serviceOrder.getId());
        pstat.setObject(2, serviceOrder.getServiceGroup());
        pstat.setObject(3, serviceOrder.getServiceTypeMow());
        pstat.setObject(4, serviceOrder.getServiceTypeEdge());
        pstat.setObject(5, serviceOrder.getServiceTypeRake());
        pstat.setObject(6, serviceOrder.getInstruction());
        pstat.setObject(7, new java.sql.Date(serviceOrder.getNeedByDate().getTime()));
        pstat.setObject(8, "javauser");
        pstat.setObject(9, GenericUtilities.getCurrentTimeStamp());
        pstat.setObject(10, "javauser");
        pstat.setObject(11, GenericUtilities.getCurrentTimeStamp());
        pstat.executeUpdate();
        lastError = null;
    } catch (SQLException sqle) {
        lastError = sqle.getMessage();
    } finally {
        if (pstat != null) {
            try {
                pstat.close();
            } catch (SQLException sqle) {
            }
        }
    }
}}

