public class Dummy{
public void insert(Modifica modifica) {
    try {
        open();
        String query = "insert into " + TBL_NAME + " (" + FIELD_DATA + "," + FIELD_TIPO + "," + FIELD_TBL + ") values("+new Timestamp(System.currentTimeMillis())+","+modifica.getTipo()+","+modifica.getTabella()+")";
        st = conn.createStatement();
        st.executeUpdate(query);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

