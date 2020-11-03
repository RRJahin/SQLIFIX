public class Dummy{
public Mappa findByNome(String search_nome) {
    ResultSet rs = null;
    Statement st;
    Mappa mappa = new Mappa();
    try {
        open();
        String query = "select * from " + TBL_NAME + " where " + FIELD_NOME + "=" + search_nome;
        st = conn.createStatement();
        rs = st.executeQuery(query);
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

