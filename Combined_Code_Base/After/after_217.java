public class Dummy{
public void insertNodo(Nodo nodo) {
    try {
        open();
        String query = "insert into ? (?,?,?,?,?,?) " + "values(?,?,?,?,?,?)";
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_CODICE ) ;
        st.setObject(3, FIELD_COORD_X);
        st.setObject(4,FIELD_COORD_Y);
        st.setObject(5,FIELD_WIDTH );
        st.setObject(6,FIELD_ID_MAPPA);
        st.setObject(7,FIELD_ID_PIANO );
        st.setObject(8, nodo.getCodice());
        st.setObject(9, nodo.getCoord_X());
        st.setObject(10, nodo.getCoord_Y());
        st.setObject(11, nodo.getLarghezza());
        st.setObject(12, nodo.getID_mappa());
        st.setObject(13, nodo.getID_piano());
        st.executeUpdate();
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

