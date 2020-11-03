public class Dummy{
public void delete(Integer id_piano) {
    try {
        open();
        String query = "delete from " + TBL_NAME + " where " + FIELD_ID + "="+id_piano;
        st = conn.createStatement();
        st.executeUpdate(query);
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Eliminazione piano");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

