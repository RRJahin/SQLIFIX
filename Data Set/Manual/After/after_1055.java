public class Dummy{
@Override
public void excluir(Connection c) throws Exception {
    String sql = "DELETE FROM pizza WHERE numero_pizza = ?;";
    PreparedStatement ps = c.prepareStatement(sql);
    ps.setObject(1, pizza.getNumero());
    int rs = ps.executeUpdate();
    resposta = rs > 0;
}}

