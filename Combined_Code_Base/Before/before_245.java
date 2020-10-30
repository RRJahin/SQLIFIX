public class Dummy{
public static order_movie findById(int order_id) {
    order_movie om = null;
    try {
        Connection con = ConnectionBuilder.getConnection();
        String s = "SELECT * FROM `order_movie` where order_id = "+order_id;
        Statement pstm = con.createStatement();
        ResultSet rs = pstm.executeQuery(s);
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

