public class Dummy{
public ArrayList<Mappa> findByIDPiano(Integer search_id) {
    ResultSet rs = null;
    PreparedStatement st;
    ArrayList<Mappa> mappe = new ArrayList<>();
    try {
        open();
        String query = "select * from ? where ?=?" + " order by ?";
        st = conn.prepareStatement(query);
        st.setObject(1, TBL_NAME);
        st.setObject(2, FIELD_ID_PIANO);
        st.setObject(3, search_id);
        st.setObject(4, FIELD_NOME);
        rs = st.executeQuery();
        while (rs.next()) {
            Mappa mappa;
            mappa = new Mappa();
            mappa.setNome(rs.getString(FIELD_NOME));
            mappa.setImmagine(rs.getString(FIELD_IMG));
            mappa.setID_mappa(rs.getInt(FIELD_ID));
            mappa.setID_piano(rs.getInt(FIELD_ID_PIANO));
            mappe.add(mappa);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
    return mappe;
}}

