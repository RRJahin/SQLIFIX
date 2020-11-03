public class Dummy{
public boolean createMap(String name) {
    if (isExist(name)) {
        return false;
    } else {
        try {
            Statement state = sql.getConn().createStatement();
            state.executeUpdate("INSERT INTO maps VALUES ('" + name + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}}

