public class Dummy{
public ArrayList<Pdi> findPdiByIDMappa(Integer search_id) {
    ResultSet rs = null;
    ArrayList<Pdi> pdis = new ArrayList<>();
    try {
        open();
        String query = "select * from ? where ?=? AND ?=true order by ?" ;
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_ID_MAPPA );
        st.setObject(3, search_id);
        st.setObject(4,FIELD_IS_PDI);
        st.setObject(5,FIELD_CODICE);
        rs = st.executeQuery();
        while (rs.next()) {
            Pdi pdi = new Pdi();
            pdi.setID(rs.getInt(FIELD_ID));
            pdi.setCodice(rs.getString(FIELD_CODICE));
            pdi.setTipo(rs.getString(FIELD_TIPO));
            pdi.setCoord_X(rs.getDouble(FIELD_COORD_X));
            pdi.setCoord_Y(rs.getDouble(FIELD_COORD_Y));
            pdi.setLarghezza(rs.getDouble(FIELD_WIDTH));
            pdi.setLunghezza(rs.getDouble(FIELD_LENGTH));
            pdi.setID_mappa(search_id);
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

