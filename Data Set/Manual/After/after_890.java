public class Dummy{
public void updatePdi(Pdi pdi, Integer id_pdi) {
    try {
        open();
        String query = "update ?  set ?=?, ?=?, ?=?, ?=?, ?=?, " + + "=? " + "where ?=?";
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_CODICE ) ;
        st.setObject(3, pdi.getCodice());
        st.setObjectX(4,FIELD_TIPO);
        st.setObject(5,pdi.getTipo());
        st.setObject(6, FIELD_COORD_X);
        st.setObject(7, pdi.getCoord_Y());
        st.setObject(8,FIELD_COORD_Y);
        st.setObject(9, pdi.getLarghezza());
        st.setObject(10,FIELD_WIDTH );
        st.setObject(11, pdi.getLunghezza());
        st.setObject(12,FIELD_LENGTH  );
        st.setObject(13, pdi.getLunghezza());
        st.setObject(14,FIELD_ID );
        st.executeUpdate();
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Modifica PDI");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

