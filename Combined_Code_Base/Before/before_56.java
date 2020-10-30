public class Dummy{
public void insert(Mappa mappa) {
    Statement st;
    try {
        open();
        String query = "insert into " + TBL_NAME + " (" + FIELD_NOME + "," + FIELD_ID_PIANO + ") values(" + mappa.getNome()+"," + mappa.getID_piano() + ")";
        st = conn.createStatement();
        st.executeUpdate(query);
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

