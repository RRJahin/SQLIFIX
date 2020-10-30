public class Dummy{
public void Insert(OrderList orderlist) {
    String sql = "INSERT INTO OrderList(bid,pid) " + "VALUES (?,?)";
    try {
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setObject(1, orderlist.getBid());
        statement.setObject(2, orderlist.getPid());
        statement.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error Insert data :" + e);
    }
}}

