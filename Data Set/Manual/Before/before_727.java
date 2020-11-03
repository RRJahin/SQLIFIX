public class Dummy{
public void delete(Integer id_mappa) {
    Statement st;
    try {
        open();
        String query = "delete from " + TBL_NAME + " where " + FIELD_ID + "=" + id_mappa;
        st = conn.createStatement();
        st.executeUpdate(query);
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Eliminazione mappa");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

