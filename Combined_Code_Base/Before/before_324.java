public class Dummy{
public Penalty create(Penalty fine) {
    try {
        connection = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
        System.out.println("Error creating connection to database: " + e);
        System.exit(-1);
    }
    Date issuedate = Date.valueOf(fine.getIssue_date());
    Date receivedate = Date.valueOf(fine.getRecd_date());
    String query2 = "INSERT INTO gaurav_penalty( penalty_id , student_id , issue_date , recd_date ,  fineamount   ) VALUES ( "+fine.getPenalty_id()+" ,"+fine.getstudent_id()+", "+issuedate+" , "+receivedate+", "+fine.getPenalty_amount()+" ) ;";
    try (Statement statement = connection.createStatement(, Statement.RETURN_GENERATED_KEYS)) {
        statement.executeUpdate(query2);
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            fine.setstudent_id(resultSet.getInt(1));
        }
    } catch (SQLException e) {
        fine = null;
        System.out.println("Error Creating Bank: " + e);
    }
    try {
        connection.close();
        connection = null;
    } catch (SQLException e) {
        System.out.println("Error closing connection: " + e);
    }
    return fine;
}}

