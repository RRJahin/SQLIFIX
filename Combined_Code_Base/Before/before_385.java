public class Dummy{
@Override
public void atualizar(Connection c) throws Exception {
    String sql = "UPDATE `sis_pizza_db`.`pizza` SET `nome_pizza` = "+pizza.getNome()+", `tipo_pizza` = "+pizza.getTipoPizza()+", `tipo_massa` = "+pizza.getTipoMassa()+", `ingredientes_pizza` = "+pizza.getIngredientes()+", `preco_pizza` = "+pizza.getPreco() + "WHERE `numero_pizza` = "+pizza.getNumero()+";";
    Statement ps = c.createStatement();
    int rs = ps.executeUpdate(sql);
    resposta = rs > 0;
}}

