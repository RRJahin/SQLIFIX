class Dummy{
public static void insertInfo(ResultItems resultItems) {
    Connection conn = getConn();
    Statement st = null;
    try {
        st = conn.createStatement();
        if (null != resultItems.get("title") && !"".equals(resultItems.get("title"))) {
            String sql = "insert into gz_second_house(`property`,`area`,`section`,`address`,`layout`,`price`,`average_price`,`contact`,`identity`,`phone`,`website`,`atime`) values(" + "'" + resultItems.get("property") + "'," + "'" + resultItems.get("area") + "'," + "'" + resultItems.get("section") + "'," + "'" + resultItems.get("address") + "'," + "'" + resultItems.get("layout") + "'," + "'" + resultItems.get("price") + "'," + "'" + resultItems.get("average_price") + "'," + "'" + resultItems.get("contact") + "'," + "'" + resultItems.get("identity") + "'," + "'" + resultItems.get("phone") + "'," + "'" + resultItems.get("website") + "'," + "'" + resultItems.get("atime") + "'" + ")";
            st.execute(sql);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        st.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

