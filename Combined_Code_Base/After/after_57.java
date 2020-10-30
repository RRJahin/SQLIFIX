public class Dummy{
public void update(Mappa mappa, Integer id_mappa) {
    PreparedStatement st;
    try {
        open();
        String query = "update ? set ?=? " + "where ?=?";
        st = conn.prepareStatement(query);
        st.setObject(1, TBL_NAME);
        st.setObject(2, FIELD_NOME);
        st.setObject(3, mappa.getNome());
        st.setObject(4, FIELD_ID);
        st.setObject(5, id_mappa);
        st.executeUpdate();
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Modifica mappa");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

