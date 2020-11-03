public class Dummy{
@Override
public boolean add(Mensagem msg) throws SQLException {
    Statement pstmt = conn.createStatement();
    int vrf = pstmt.executeUpdate("insert into mensagem(de, para, mensagem) values("+msg.getDeEmail()+","+msg.getParaEmail()+","+msg.getMensagem()+")");
    pstmt.close();
    return vrf > 0;
}}

