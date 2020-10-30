class Dummy{
public static void removeRepo(String repoUrl) throws SQLException {
    Connection conn = DriverManager.getConnection("jdbc:default:connection");
    String query = "DELETE FROM localdb.sys_network.repositories WHERE " + "repo_url = ?";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setObject(1, repoUrl);
    ps.execute();
    ps.close();
}}

