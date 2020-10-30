public class Dummy{
public boolean createMap(String name) {
    if (isExist(name)) {
        return false;
    } else {
        try {
            String st = "INSERT INTO maps VALUES ('?')";
            PreparedStatement state = sql.getConn().prepareStatement(st);
            state.setObject(1, name);
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}}

