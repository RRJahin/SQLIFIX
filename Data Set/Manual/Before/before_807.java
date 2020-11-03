public class Dummy{
public ServiceOrder displayService(int id) {
    String sql = "SELECT * FROM service_order " + "WHERE expiration_date IS null AND id = " + id;
    Statement stat = null;
    ResultSet rs = null;
    ServiceOrder serviceOrder = null;
    try {
        stat = CONN.createStatement();
        rs = stat.executeQuery(sql);
        if (rs.next()) {
            Date rsNeedByDate = null;
            if (rs.getDate("need_by_date") != null) {
                rsNeedByDate = new Date(rs.getDate("need_by_date").getTime());
            } else {
                rsNeedByDate = null;
            }
            Date rsScheduledDate = null;
            if (rs.getDate("scheduled_date") != null) {
                rsScheduledDate = new Date(rs.getDate("scheduled_date").getTime());
            } else {
                rsScheduledDate = null;
            }
            Date rsCompletedDate = null;
            if (rs.getDate("completed_date") != null) {
                rsCompletedDate = new Date(rs.getDate("completed_date").getTime());
            } else {
                rsCompletedDate = null;
            }
            Date rsExpirationDate = null;
            if (rs.getDate("expiration_date") != null) {
                rsExpirationDate = new Date(rs.getDate("completed_date").getTime());
            } else {
                rsExpirationDate = null;
            }
            Date rsCreateDate = null;
            if (rs.getTimestamp("create_date") != null) {
                rsCreateDate = rs.getTimestamp("create_date");
                rsCreateDate = new Date(rsCreateDate.getTime());
            } else {
                rsCreateDate = null;
            }
            Date rsChangeDate = null;
            if (rs.getTimestamp("change_date") != null) {
                rsChangeDate = rs.getTimestamp("change_date");
                rsChangeDate = new Date(rsChangeDate.getTime());
            } else {
                rsChangeDate = null;
            }
            serviceOrder = new ServiceOrder();
            serviceOrder.setId(rs.getInt("id"));
            serviceOrder.setMemberId(rs.getInt("memberid"));
            serviceOrder.setServiceGroup(rs.getString("service_group"));
            serviceOrder.setServiceTypeMow(rs.getString("service_type_mow"));
            serviceOrder.setServiceTypeEdge(rs.getString("service_type_edge"));
            serviceOrder.setServiceTypeRake(rs.getString("service_type_rake"));
            serviceOrder.setInstruction(rs.getString("instruction"));
            serviceOrder.setNeedByDate(rsNeedByDate);
            serviceOrder.setScheduledDate(rsScheduledDate);
            serviceOrder.setCompletedFlag(rs.getBoolean("completed_flag"));
            serviceOrder.setCompletedDate(rsCompletedDate);
            serviceOrder.setExpirationDate(rsExpirationDate);
            serviceOrder.setCreateUserName(rs.getString("create_user_name"));
            serviceOrder.setCreateDate(rsCreateDate);
            serviceOrder.setChangeUserName(rs.getString("change_user_name"));
            serviceOrder.setChangeDate(rsChangeDate);
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
    return serviceOrder;
}}

