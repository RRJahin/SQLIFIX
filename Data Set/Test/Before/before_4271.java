class Dummy{
public void save(ProjectDetails projectDetails) {
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "avinash", "tiger");
        Statement statement = connection.createStatement();
        System.out.println("2insert3");
        System.out.println("2insert4");
        statement.executeUpdate("insert into project_hrm values("+projectDetails.getName()+","+projectDetails.getClients()+","+projectDetails.getId()+","+projectDetails.getTeamsize()+")");
        System.out.println("2insert5");
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

