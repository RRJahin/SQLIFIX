import java.sql.PreparedStatement;

public class Dummy{
public boolean registerUser(String username, String password) throws DatabaseException {
    String Register_SQL_QUERY = "Insert into ? (Username,Password) values(? , ?);";
    try (PreparedStatement RegisterUserStmt = databaseConnection.prepareStatement(Register_SQL_QUERY)) {
        RegisterUserStmt.setObject(1, dbTableName);
        RegisterUserStmt.setObject(2, username);
        RegisterUserStmt.setObject(3, password);

        boolean isRegistered = false;
        if (RegisterUserStmt.executeUpdate() == 1) {
            isRegistered = true;
        }
        return isRegistered;
    } catch (SQLException ex) {
        if (ex.getErrorCode() == 1062 || ex.getErrorCode() == 23505) {
            throw new DatabaseException("Sorry, The Username " + username + " already exists! ", ex);
        } else {
            throw new DatabaseException("SQLException occured while inserting user record in registerUser Method", ex);
        }
    }
}}

