public class Dummy{
public void updateNodo(Nodo nodo, Integer id_nodo) {
    try {
        open();
        String query = "update " + TBL_NAME + " set " + FIELD_CODICE + "="+nodo.getCodice()+", " + FIELD_COORD_X + "="+nodo.getCoord_X()+", " + FIELD_COORD_Y + "="+nodo.getCoord_Y()+", " + FIELD_WIDTH + "="+nodo.getLarghezza()+" " + "where " + FIELD_ID + "="+id_nodo;
        st = conn.createStatement();
        st.executeUpdate(query);
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Modifica nodo");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

