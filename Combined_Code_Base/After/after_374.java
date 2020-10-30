public class Dummy{
public Piano findById(Integer search_id) {
    ResultSet rs = null;
    Piano piano = new Piano();
    try {
        open();
        String query = "select * from ? where ?= ?";
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_ID);
        st.setObject(3, search_id);
        rs = st.executeQuery();
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

