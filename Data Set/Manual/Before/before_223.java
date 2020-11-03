public class Dummy{
public void startEmergency() {
    try {
        open();
        String query = "insert into " + TBL_NAME + " (" + FIELD_EMERG + ") values("+true+")";
        st = conn.createStatement();
        st.executeUpdate(query);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

