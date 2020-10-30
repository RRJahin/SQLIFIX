public class Dummy{
public List<ServiceOrder> getListServices(int id) {
    List<ServiceOrder> listServices = new ArrayList<>();
    String sql = "SELECT * FROM service_order " + "WHERE memberid = " + id + " AND expiration_date IS null " + "ORDER BY need_by_date DESC";
    Statement stat = null;
    ResultSet rs = null;
    try {
        stat = CONN.createStatement();
        rs = stat.executeQuery(sql);
        while (rs.next()) {
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
            ServiceOrder sh = new ServiceOrder(rs.getString("service_group"), rsNeedByDate, rsScheduledDate, rs.getBoolean("completed_flag"), rs.getInt("id"));
            listServices.add(sh);
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
    return listServices;
}}

