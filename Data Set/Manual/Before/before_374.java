public class Dummy{
public Piano findById(Integer search_id) {
    ResultSet rs = null;
    Piano piano = new Piano();
    try {
        open();
        String query = "select * from " + TBL_NAME + " where " + FIELD_ID + "= "+search_id;
        st = conn.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            piano.setQuota(rs.getString(FIELD_QUOTA));
            piano.setID_piano(rs.getInt(FIELD_ID));
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
    return piano;
}}

