public class Dummy{
public void insert(Modifica modifica) {
    try {
        open();
        String query = "insert into " + TBL_NAME + " (" + FIELD_DATA + "," + FIELD_TIPO + "," + FIELD_TBL + ") values(?,?,?)";
        st = conn.prepareStatement(query);
        st.setObject(1, new Timestamp(System.currentTimeMillis()));
        st.setObject(2, modifica.getTipo());
        st.setObject(3, modifica.getTabella());
        st.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

