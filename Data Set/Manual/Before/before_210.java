public class Dummy{
public ArrayList<Pdi> findAllPdi() {
    ResultSet rs = null;
    ArrayList<Pdi> pdis = new ArrayList<>();
    try {
        open();
        String query = "select * from " + TBL_NAME + " where " + FIELD_IS_PDI + "=true" + "order by " + FIELD_CODICE;
        st = conn.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            Pdi pdi = new Pdi();
            pdi.setID(rs.getInt(FIELD_ID));
            pdi.setCodice(rs.getString(FIELD_CODICE));
            pdi.setTipo(rs.getString(FIELD_TIPO));
            pdi.setCoord_X(rs.getDouble(FIELD_COORD_X));
            pdi.setCoord_Y(rs.getDouble(FIELD_COORD_Y));
            pdi.setLarghezza(rs.getDouble(FIELD_WIDTH));
            pdi.setLunghezza(rs.getDouble(FIELD_LENGTH));
            pdi.setID_mappa(rs.getInt(FIELD_ID_MAPPA));
            pdi.setID_piano(rs.getInt(FIELD_ID_PIANO));
            pdis.add(pdi);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
    return pdis;
}}

