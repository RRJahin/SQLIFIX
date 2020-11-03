public class Dummy{
public void abortEmergency() {
    try {
        open();
        String query = "insert into " + TBL_NAME + " (" + FIELD_EMERG + ") values("+false+")";
        st = conn.createStatement();
        st.executeUpdate(query);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

