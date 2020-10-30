public class Dummy{
@Override
public List<Mensagem> listar(String userParaEmail) throws SQLException {
    PreparedStatement pstmt = conn.prepareStatement("select * from mensagem where para = '" + userParaEmail + "'");
    List<Mensagem> mensagens = new ArrayList();
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
        Mensagem msg = new Mensagem();
        msg.setId(rs.getInt(1));
        msg.setDeEmail(rs.getString(2));
        msg.setParaEmail(rs.getString(3));
        msg.setMensagem(rs.getString(4));
        mensagens.add(msg);
    }
    pstmt.close();
    rs.close();
    return mensagens;
}}

