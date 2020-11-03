public class Dummy{
public Item process(String key) throws Exception {
    Connection con = createConnection();
    String cmd = "select * from ? where key='?'";
    PreparedStatement st = con.prepareStatement(cmd);
    st.setObject(1, getParam().getTableName());
    st.setObject(2, key);
    ResultSet rs = st.executeQuery();
    List<Item> rlist = new ArrayList<Item>();
    while (rs.next()) {
        rlist.add(new ItemBuildClosure().call(rs));
    }
    rs.close();
    st.close();
    con.close();
    if (rlist.size() > 0) {
        return rlist.get(0);
    }
    return null;
}}

