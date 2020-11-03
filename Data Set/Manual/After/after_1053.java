public class Dummy{
@Override
public void cadastrar(Connection c) throws Exception {
    String sql = "INSERT INTO `sis_pizza_db`.`pizza` (`numero_pizza`, `nome_pizza`, `tipo_pizza`, `tipo_massa`, `ingredientes_pizza`, `preco_pizza`)" + "VALUES (?, ?, ?, ?, ?, ?);";
    PreparedStatement ps = c.prepareStatement(sql);
    ps.setObject(1, pizza.getNumero());
    ps.setObject(2, pizza.getNome());
    ps.setObject(3, pizza.getTipoPizza());
    ps.setObject(4, pizza.getTipoMassa());
    ps.setObject(5, pizza.getIngredientes());
    ps.setObject(6, pizza.getPreco());
    int rs = ps.executeUpdate();
    resposta = rs > 0;
}}

