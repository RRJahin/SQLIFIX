public class Dummy{
public static order_movie findById(int order_id) {
    order_movie om = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "SELECT * FROM `order_movie` where order_id = ?";
        PreparedStatement pstm = con.prepareStatement(s);
        pstm.setObject(1, order_id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            om = new order_movie();
            om.setMovie_id(rs.getInt("movie_id"));
            om.setOrder_id(rs.getInt("order_id"));
            om.setQty(rs.getInt("qty"));
        }
        con.close();
    } catch (Exception ex) {
        System.out.println("findById order_move error: " + ex);
    }
    return om;
}}

