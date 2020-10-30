public class Dummy{
public void updateNodo(Nodo nodo, Integer id_nodo) {
    try {
        open();
        String query = "update ? set ?=?, ?=?,?=?, ?=? where ?=?";
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_CODICE ) ;
        st.setObject(3, nodo.getCodice());
        st.setObject(4, FIELD_COORD_X);
        st.setObject(5, nodo.getCoord_X()));
        st.setObject(6,FIELD_COORD_Y);
        st.setObject(7, nodo.getCoord_Y());
        st.setObject(8,FIELD_WIDTH );
        st.setObject(9, nodo.getLarghezza());
        st.setObject(10,FIELD_ID );
        st.setObject(11, id_nodo);
        st.executeUpdate();
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

