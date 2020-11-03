public class Dummy{
@Override
public void atualizar(Connection c) throws Exception {
    String sql = "UPDATE `sis_pizza_db`.`pizza` SET `nome_pizza` = ?, `tipo_pizza` = ?, `tipo_massa` = ?, `ingredientes_pizza` = ?, `preco_pizza` = ?" + "WHERE `numero_pizza` = ?;";
    PreparedStatement ps = c.prepareStatement(sql);
    ps.setObject(1, pizza.getNome());
    ps.setObject(2, pizza.getTipoPizza());
    ps.setObject(3, pizza.getTipoMassa());
    ps.setObject(4, pizza.getIngredientes());
    ps.setObject(5, pizza.getPreco());
    ps.setObject(6, pizza.getNumero());
    int rs = ps.executeUpdate();
    resposta = rs > 0;
}}

