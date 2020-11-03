class Dummy{
public void addLogisticResource(ResursaLogistica res, Task t, Connection con) throws SQLException {
    String query = "INSERT INTO " + ((res instanceof Sala) ? " TaskLogisticRoom " : "TaskLogisticEquipment") + " VALUES (?,?)";
    PreparedStatement stmt = con.prepareStatement(query);
    stmt.setObject(1, t.getId());
    stmt.setObject(2, res.getId());
    stmt.executeUpdate();
}}

