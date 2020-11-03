class Dummy{
public void addLogisticResource(ResursaLogistica res, Task t, Connection con) throws SQLException {
    String query = "INSERT INTO " + ((res instanceof Sala) ? " TaskLogisticRoom " : "TaskLogisticEquipment") + " VALUES ("+t.getId()+","+res.getId()+")";
    Statement stmt = con.createStatement();
    stmt.executeUpdate(query);
}}

