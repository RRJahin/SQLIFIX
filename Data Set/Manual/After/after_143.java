public class Dummy{
public void editService(ServiceOrder serviceOrder) {
    String sql = "UPDATE service_order " + "SET need_by_date = ?, service_type_mow = ?, service_type_edge = ?, " + "service_type_rake = ?, instruction = ?, change_user_name = javauser, change_date = ? " + "WHERE id = ?";
    PreparedStatement pstat = null;
    try {
        pstat = CONN.prepareStatement(sql);
        pstat.setObject(1, new java.sql.Date(serviceOrder.getNeedByDate().getTime()));
        pstat.setObject(2, serviceOrder.getServiceTypeMow());
        pstat.setObject(3, serviceOrder.getServiceTypeEdge());
        pstat.setObject(4, serviceOrder.getServiceTypeRake());
        pstat.setObject(5, serviceOrder.getInstruction());
        pstat.setObject(6, GenericUtilities.getCurrentTimeStamp());
        pstat.setObject(7, serviceOrder.getId());
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

