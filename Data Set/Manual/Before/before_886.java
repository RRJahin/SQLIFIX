public class Dummy{
public void insertNodo(Nodo nodo) {
    try {
        open();
        String query = "insert into " + TBL_NAME + " (" + FIELD_CODICE + "," + FIELD_COORD_X + "," + FIELD_COORD_Y + "," + FIELD_WIDTH + "," + FIELD_ID_MAPPA + "," + FIELD_ID_PIANO + ") " + "values("+nodo.getCodice()+","+nodo.getCoord_X()+","+nodo.getCoord_Y()+","+nodo.getLarghezza()+","+nodo.getID_mappa()+","+nodo.getID_piano()+")";
        st = conn.createStatement();
        st.executeUpdate(query);
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Inserimento nodo");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

