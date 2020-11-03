public class Dummy{
public boolean isExist(String name) {
    try {
        String query = "SELECT map FROM maps WHERE map = '?'";
        PreparedStatement state = sql.getConn().prepareStatement(query);
        state.setObject(1, name);
        ResultSet result;
        result = state.executeQuery();
        return result.next();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}}

