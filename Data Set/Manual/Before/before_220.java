public class Dummy{
public void insertPdi(Pdi pdi) {
    try {
        open();
        String query = "insert into " + TBL_NAME + " (" + FIELD_CODICE + "," + FIELD_IS_PDI + "," + FIELD_TIPO + "," + FIELD_COORD_X + "," + FIELD_COORD_Y + "," + FIELD_WIDTH + "," + FIELD_LENGTH + "," + FIELD_ID_MAPPA + "," + FIELD_ID_PIANO + ") values("+pdi.getCodice()+","+true+","+pdi.getTipo()+","+pdi.getCoord_X()+","+pdi.getCoord_Y()+","+pdi.getLarghezza()+","+pdi.getLunghezza()+","+pdi.getID_mappa()+","+pdi.getID_piano()+")";
        st = conn.createStatement();
        st.executeUpdate(query);
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

