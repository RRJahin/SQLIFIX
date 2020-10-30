public class Dummy{
public void update(Mappa mappa, Integer id_mappa) {
    Statement st;
    try {
        open();
        String query = "update " + TBL_NAME + " set " + FIELD_NOME + "=" + mappa.getNome() + "where " + FIELD_ID + "=" + id_mappa;
        st = conn.createStatement();
        st.executeUpdate(query);
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

