public class Dummy{
public Nodo findByID(Integer search_id) {
    ResultSet rs = null;
    Nodo nodo = new Nodo();
    try {
        open();
        String query = "select * from " + TBL_NAME + " where " + FIELD_ID + "= "+search_id;
        st = conn.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            nodo.setID(search_id);
            nodo.setCodice(rs.getString(FIELD_CODICE));
            nodo.setCoord_X(rs.getDouble(FIELD_COORD_X));
            nodo.setCoord_Y(rs.getDouble(FIELD_COORD_Y));
            nodo.setID_mappa(rs.getInt(FIELD_ID_MAPPA));
            nodo.setID_piano(rs.getInt(FIELD_ID_PIANO));
            nodo.setLarghezza(rs.getDouble(FIELD_WIDTH));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
    return nodo;
}}

