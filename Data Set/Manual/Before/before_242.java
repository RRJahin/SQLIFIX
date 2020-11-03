public class Dummy{
public void Insert(OrderList orderlist) {
    String sql = "INSERT INTO OrderList(bid,pid) " + "VALUES ("+orderlist.getBid()+","+orderlist.getPid()+")";
    try {
        Statement statement = con.createStatement();
        statement.executeUpdate(sql);
    } catch (SQLException e) {
        System.err.println("Error Insert data :" + e);
    }
}}

