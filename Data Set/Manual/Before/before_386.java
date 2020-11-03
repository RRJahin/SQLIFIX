public class Dummy{
@Override
public void excluir(Connection c) throws Exception {
    String sql = "DELETE FROM pizza WHERE numero_pizza = "+pizza.getNumero()+";";
    Statement ps = c.createStatement();
    int rs = ps.executeUpdate(sql);
    resposta = rs > 0;
}}

