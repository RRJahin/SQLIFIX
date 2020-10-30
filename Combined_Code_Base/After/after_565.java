class Dummy{
public void addTeam(CadruDidactic cd, Task t, Connection con) throws SQLException {
    String query = "INSERT INTO TaskTeam VALUES (?,?)";
    PreparedStatement stmt = con.prepareStatement(query);
    stmt.setObject(1, t.getId());
    stmt.setObject(2, cd.getId());
    stmt.executeUpdate();
}}

