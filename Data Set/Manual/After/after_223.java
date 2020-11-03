public class Dummy{
public void startEmergency() {
    try {
        open();
        String query = "insert into ?(?) values(?)";
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_EMERG) ;
        st.setBoolean(3, true);
        st.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

