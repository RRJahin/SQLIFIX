public class Dummy{
public Pdi findPdiByID(Integer search_id) {
    ResultSet rs = null;
    Pdi pdi = new Pdi();
    try {
        open();
        String query = "select * from ? where ?= ?";
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_ID );
        st.setObject(3, search_id);
        rs = st.executeQuery();
        while (rs.next()) {
            pdi.setID(search_id);
            pdi.setCodice(rs.getString(FIELD_CODICE));
            pdi.setTipo(rs.getString(FIELD_TIPO));
            pdi.setCoord_X(rs.getDouble(FIELD_COORD_X));
            pdi.setCoord_Y(rs.getDouble(FIELD_COORD_Y));
            pdi.setID_mappa(rs.getInt(FIELD_ID_MAPPA));
            pdi.setID_piano(rs.getInt(FIELD_ID_PIANO));
            pdi.setLarghezza(rs.getDouble(FIELD_WIDTH));
            pdi.setLunghezza(rs.getDouble(FIELD_LENGTH));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
    return pdi;
}}

