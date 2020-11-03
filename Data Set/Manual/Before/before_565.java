class Dummy{
public void addTeam(CadruDidactic cd, Task t, Connection con) throws SQLException {
    String query = "INSERT INTO TaskTeam VALUES ("+t.getId()+","+cd.getId()+")";
    Statement stmt = con.createStatement();
    stmt.executeUpdate(query);
}}

