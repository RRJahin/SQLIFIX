public class Dummy{
public Item process(String key) throws Exception {
    Connection con = createConnection();
    Statement st = con.createStatement();
    String cmd = "select * from " + getParam().getTableName() + " where key='" + key + "'";
    ResultSet rs = st.executeQuery(cmd);
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

