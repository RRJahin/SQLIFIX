public class Dummy{
public void insertPdi(Pdi pdi) {
    try {
        open();
        String query = "insert into " + TBL_NAME + " (" + FIELD_CODICE + "," + FIELD_IS_PDI + "," + FIELD_TIPO + "," + FIELD_COORD_X + "," + FIELD_COORD_Y + "," + FIELD_WIDTH + "," + FIELD_LENGTH + "," + FIELD_ID_MAPPA + "," + FIELD_ID_PIANO + ") values(?,?,?,?,?,?,?,?,?)";
        st = conn.prepareStatement(query);
        st.setObject(1, pdi.getCodice());
        st.setBoolean(2, true);
        st.setObject(3, pdi.getTipo());
        st.setObject(4, pdi.getCoord_X());
        st.setObject(5, pdi.getCoord_Y());
        st.setObject(6, pdi.getLarghezza());
        st.setObject(7, pdi.getLunghezza());
        st.setObject(8, pdi.getID_mappa());
        st.setObject(9, pdi.getID_piano());
        st.executeUpdate();
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Inserimento PDI");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

