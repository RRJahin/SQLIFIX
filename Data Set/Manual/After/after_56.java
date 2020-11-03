public class Dummy{
public void insert(Mappa mappa) {
    PreparedStatement st;
    try {
        open();
        String query = "insert into ? (?,?) values(?,?)";
        st = conn.prepareStatement(query);
        st.setObject(1, TBL_NAME);
        st.setObject(2, FIELD_NOME);
        st.setObject(3, FIELD_ID_PIANO);
        st.setObject(4, mappa.getNome());
        st.setObject(5, mappa.getID_piano());
        st.executeUpdate();
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Inserimento mappa");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

