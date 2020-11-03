class Dummy{
@Override
public Customer getCustomerByName(String name) {
    Customer customer = null;
    Statement pstmt = null;
    ResultSet rs = null;
    try {
        Connection con = dataSource.getConnection();
        pstmt = con.createStatement();
        rs = pstmt.executeQuery("select id,lastname,firstname,age from customer where name = "+name);
        if (rs.next()) {
            customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setLastname(rs.getString("name"));
            customer.setFirstname(rs.getString("firstname"));
            customer.setAge(rs.getInt("age"));
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    return customer;
}}

