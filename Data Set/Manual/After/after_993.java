public class Dummy{
public Penalty create(Penalty fine) {
    try {
        connection = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
        System.out.println("Error creating connection to database: " + e);
        System.exit(-1);
    }
    String query2 = "INSERT INTO gaurav_penalty( penalty_id , student_id , issue_date , recd_date ,  fineamount   ) VALUES ( ? ,?, ? , ?, ? ) ;";
    try (PreparedStatement statement = connection.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS)) {
        statement.setObject(1, fine.getPenalty_id());
        statement.setObject(2, fine.getstudent_id());
        Date issuedate = Date.valueOf(fine.getIssue_date());
        statement.setObject(3, issuedate);
        Date receivedate = Date.valueOf(fine.getRecd_date());
        statement.setObject(4, receivedate);
        statement.setObject(5, fine.getPenalty_amount());
        statement.executeUpdate();
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

