public class Dummy{
public ArrayList<Mappa> findByIDPiano(Integer search_id) {
    ResultSet rs = null;
    Statement st;
    ArrayList<Mappa> mappe = new ArrayList<>();
    try {
        open();
        String query = "select * from " + TBL_NAME + " where " + FIELD_ID_PIANO + "=" + search_id + " order by " + FIELD_NOME;
        st = conn.createStatement();
        rs = st.executeQuery(query);
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

