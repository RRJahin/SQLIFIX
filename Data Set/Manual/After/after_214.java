public class Dummy{
public ArrayList<Nodo> findByIDMappa(Integer search_id) {
    ResultSet rs = null;
    ArrayList<Nodo> nodi = new ArrayList<>();
    try {
        open();
        String query = "select * from ? where ?=? AND ?=false order by ?"  ;
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_ID_MAPPA);
        st.setObject(3, search_id);
        st.setObject(4,FIELD_IS_PDI);
        st.setObject(5,FIELD_CODICE);
        rs = st.executeQuery();
        while (rs.next()) {
            Nodo nodo = new Nodo();
            nodo.setID(rs.getInt(FIELD_ID));
            nodo.setCodice(rs.getString(FIELD_CODICE));
            nodo.setCoord_X(rs.getDouble(FIELD_COORD_X));
            nodo.setCoord_Y(rs.getDouble(FIELD_COORD_Y));
            nodo.setLarghezza(rs.getDouble(FIELD_WIDTH));
            nodo.setID_piano(rs.getInt(FIELD_ID_PIANO));
            nodo.setID_mappa(search_id);
            nodi.add(nodo);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
    return nodi;
}}

