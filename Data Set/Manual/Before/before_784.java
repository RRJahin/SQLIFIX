public class Dummy{
@Override
public boolean remove(int id) throws SQLException {
    Statement pstmt = conn.createStatement();
    int vrf = pstmt.executeUpdate("delete from mensagem where id = '" + id + "'");
    return vrf > 0;
}}

