public class Dummy{
public static List<order_movie> findByIdList(int order_id) {
    List<order_movie> lom = null;
    order_movie om = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "SELECT * FROM `order_movie` where order_id = ?";
        PreparedStatement pstm = con.prepareStatement(s);
        pstm.setObject(1, order_id);
        ResultSet rs = pstm.executeQuery();
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

