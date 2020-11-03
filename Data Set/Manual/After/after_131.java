public class Dummy{
public ArrayList<Modifica> findAllAfterDate(Timestamp data) {
    ResultSet rs = null;
    ArrayList<Modifica> modifiche = new ArrayList<>();
    try {
        open();
        String query = "select * from " + TBL_NAME + " where " + FIELD_DATA + " >= ? ";
        st = conn.prepareStatement(query);
        st.setObject(1, data);
        rs = st.executeQuery();
        while (rs.next()) {
            Modifica modifica = new Modifica();
            modifica.setID_modifica(rs.getInt(FIELD_ID));
            modifica.setID_oggetto(rs.getInt(FIELD_OBJ));
            modifica.setTabella(rs.getString(FIELD_TBL));
            modifica.setTipo(rs.getString(FIELD_TIPO));
            modifica.setData(rs.getTimestamp(FIELD_DATA).getTime());
            modifiche.add(modifica);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
    return modifiche;
}}

