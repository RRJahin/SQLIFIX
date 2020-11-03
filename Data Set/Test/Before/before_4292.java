class Dummy{
@Override
public void save(Customer customer) {
    Statement pstmt = null;
    try {
        Connection con = dataSource.getConnection();
        pstmt = con.createStatement();
        pstmt.executeUpdate("insert into customer(lastname, firstname, age) values('" + customer.getLastname() + "','" + customer.getFirstname() + "'," + customer.getAge() + ")");
    } catch (Exception e) {
        throw new RuntimeException(e);
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}}

