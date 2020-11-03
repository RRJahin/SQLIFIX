public class Dummy{
public void createServices(ServiceOrder serviceOrder) {
    String sql = "INSERT INTO service_order " + "(memberid, service_group, service_type_mow, service_type_edge, service_type_rake, " + "instruction, need_by_date, create_user_name, create_date, change_user_name, change_date)" + "VALUES ("+serviceOrder.getId()+","+serviceOrder.getServiceGroup()+","+serviceOrder.getServiceTypeMow()+","+serviceOrder.getServiceTypeEdge()+","+serviceOrder.getServiceTypeRake()+","+serviceOrder.getInstruction()+","+new java.sql.Date(serviceOrder.getNeedByDate().getTime())+",javauser,"+GenericUtilities.getCurrentTimeStamp()+",javauser,"+GenericUtilities.getCurrentTimeStamp()+")";
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

