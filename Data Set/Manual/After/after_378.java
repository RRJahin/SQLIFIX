public class Dummy{
public void update(String quota, Integer id_piano) {
    try {
        open();
        String query = "update ? set ?=? where ?=?";
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_QUOTA);
        st.setObject(3, quota);
        st.setObject(4, id_piano);
        st.executeUpdate();
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Modifica piano");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

