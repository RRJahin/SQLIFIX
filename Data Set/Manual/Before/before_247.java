public class Dummy{
public static List<order_movie> findByIdList(int order_id) {
    List<order_movie> lom = null;
    order_movie om = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "SELECT * FROM `order_movie` where order_id = "+order_id;
        Statement pstm = con.createStatement();
        ResultSet rs = pstm.executeQuery(s);
        while (rs.next()) {
            if (lom == null) {
                lom = new ArrayList<>();
            }
            om = new order_movie();
            om.setMovie_id(rs.getInt("movie_id"));
            om.setOrder_id(rs.getInt("order_id"));
            om.setQty(rs.getInt("qty"));
            lom.add(om);
        }
        con.close();
    } catch (Exception ex) {
        System.out.println("findById order_move error: " + ex);
    }
    return lom;
}}

