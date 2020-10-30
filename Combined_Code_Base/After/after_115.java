public class Dummy{
@Override
public boolean remove(int id) throws SQLException {
    PreparedStatement pstmt = conn.prepareStatement("delete from mensagem where id = '?'");
    pstmt.setObject(1,id);
    int vrf = pstmt.executeUpdate();
    return vrf > 0;
}}

