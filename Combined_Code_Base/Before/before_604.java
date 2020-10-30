class Dummy{
public static void addRepo(String repoUrl) throws SQLException {
    Connection conn = DriverManager.getConnection("jdbc:default:connection");
    String query = "INSERT INTO localdb.sys_network.repositories (repo_url) " + "VALUES ("+repoUrl+")";
    Statement ps = conn.createStatement();
    ps.execute(query);
    ps.close();
}}

