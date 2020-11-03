class Dummy{
public static void addRepo(String repoUrl) throws SQLException {
    Connection conn = DriverManager.getConnection("jdbc:default:connection");
    String query = "INSERT INTO localdb.sys_network.repositories (repo_url) " + "VALUES (?)";
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setObject(1, repoUrl);
    ps.execute();
    ps.close();
}}

