public class Dummy{
public Mappa findByID(Integer search_id) {
    ResultSet rs = null;
    PreparedStatement st;
    Mappa mappa = new Mappa();
    try {
        open();
        String query = "select * from ? where ?=?";
        st = conn.prepareStatement(query);
        st.setObject(1, TBL_NAME);
        st.setObject(2, FIELD_ID);
        st.setObject(3, search_id);
        rs = st.executeQuery();
        while (rs.next()) {
            mappa.setNome(rs.getString(FIELD_NOME));
            mappa.setImmagine(rs.getString(FIELD_IMG));
            mappa.setID_mappa(rs.getInt(FIELD_ID));
            mappa.setID_piano(rs.getInt(FIELD_ID_PIANO));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
    return mappa;
}}

