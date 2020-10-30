public class Dummy{
public boolean isExist(String name) {
    try {
        Statement state = sql.getConn().createStatement();
        ResultSet result;
        result = state.executeQuery("SELECT map FROM maps WHERE map = '" + name + "'");
        return result.next();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}}

