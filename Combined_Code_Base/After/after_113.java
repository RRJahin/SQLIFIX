public class Dummy{
@Override
public boolean add(Mensagem msg) throws SQLException {
    PreparedStatement pstmt = conn.prepareStatement("insert into mensagem(de, para, mensagem) values(?,?,?)");
    pstmt.setObject(1, msg.getDeEmail());
    pstmt.setObject(2, msg.getParaEmail());
    pstmt.setObject(3, msg.getMensagem());
    int vrf = pstmt.executeUpdate();
    pstmt.close();
    return vrf > 0;
}}

