public class Dummy{
public Nodo findByCodice(String search_code) {
    ResultSet rs = null;
    Nodo nodo = new Nodo();
    try {
        open();
        String query = "select * from ? where ?= ?";
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_CODICE  );
        st.setObject(3, search_code);
        rs = st.executeQuery();
        while (rs.next()) {
            nodo.setID(rs.getInt(FIELD_ID));
            nodo.setCodice(search_code);
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

