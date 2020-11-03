public class Dummy{
public void updatePdi(Pdi pdi, Integer id_pdi) {
    try {
        open();
        String query = "update " + TBL_NAME + " set " + FIELD_CODICE + "="+pdi.getCodice()+", " + FIELD_TIPO + "="+pdi.getTipo()+", " + FIELD_COORD_X + "="+pdi.getCoord_X()+", " + FIELD_COORD_Y + "="+pdi.getCoord_Y()+", " + FIELD_WIDTH + "="+pdi.getLarghezza()+", " + FIELD_LENGTH + "= "+pdi.getLunghezza() + " where " + FIELD_ID + "="+id_pdi;
        st = conn.createStatement();
        st.executeUpdate(query);
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

