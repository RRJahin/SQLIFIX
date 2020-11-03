public class Dummy{
public void editService(ServiceOrder serviceOrder) {
    String sql = "UPDATE service_order " + "SET need_by_date = "+new java.sql.Date(serviceOrder.getNeedByDate().getTime())+", service_type_mow = "+serviceOrder.getServiceTypeMow()+", service_type_edge = "+serviceOrder.getServiceTypeEdge()+", " + "service_type_rake = "+serviceOrder.getServiceTypeRake()+", instruction = "+serviceOrder.getInstruction()+", change_user_name = javauser, change_date = "+GenericUtilities.getCurrentTimeStamp()+" " + "WHERE id = "+serviceOrder.getId();
    Statement pstat = null;
    try {
        pstat = CONN.createStatement();
        pstat.executeUpdate(sql);
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

