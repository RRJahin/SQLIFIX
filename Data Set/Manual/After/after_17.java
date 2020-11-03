import java.sql.PreparedStatement;

public class Dummy {

  public String loginUser(String username) throws DatabaseException {
    String Login_SQL_QUERY = "Select Password from ? where Username = ?;";

    try (
      PreparedStatement LoginUserStmt = databaseConnection.prepareStatement(
        Login_SQL_QUERY
      )
    ) {
      LoginUserStmt.setObject(1, dbTableName);
      LoginUserStmt.setObject(2, username);
      try (ResultSet QueryResult = LoginUserStmt.executeQuery()) {
        String password = null;
        if (QueryResult.isBeforeFirst() && QueryResult.next()) {
          password = QueryResult.getString(1);
        }
        return password;
      } catch (SQLException ex) {
        throw new DatabaseException(
          "SQLException occured in ResultSet of LoginUser method",
          ex
        );
      }
    } catch (SQLException ex) {
      throw new DatabaseException("SQLException in LoginUser Method", ex);
    }
  }
}
