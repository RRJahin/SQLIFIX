public class Dummy{
public ArrayList<Nodo> findByIDMappa(Integer search_id) {
    ResultSet rs = null;
    ArrayList<Nodo> nodi = new ArrayList<>();
    try {
        open();
        String query = "select * from " + TBL_NAME + " where " + FIELD_ID_MAPPA + "="+search_id+" AND " + FIELD_IS_PDI + "=false order by " + FIELD_CODICE;
        st = conn.createStatement();
        rs = st.executeQuery(query);
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

