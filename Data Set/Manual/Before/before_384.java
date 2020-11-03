public class Dummy{
@Override
public void cadastrar(Connection c) throws Exception {
    String sql = "INSERT INTO `sis_pizza_db`.`pizza` (`numero_pizza`, `nome_pizza`, `tipo_pizza`, `tipo_massa`, `ingredientes_pizza`, `preco_pizza`)" + "VALUES ("+pizza.getNumero()+", "+pizza.getNome()+", "+pizza.getTipoPizza()+", "+pizza.getTipoMassa()+", "+pizza.getIngredientes()+", "+pizza.getPreco()+");";
    Statement ps = c.createStatement();
    int rs = ps.executeUpdate(sql);
    resposta = rs > 0;
}}

