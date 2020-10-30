public class Dummy{
public void update(Agricultor agricultor) throws Exception {
    String SQL = "UPDATE CADASTROAGRICULTOR SET NOME=?, DATA_CADASTRO=?, MUNICIPIO=?, LOCALIDADE=?, PRODUTOS=?, STATUS=?, TELEFONE=? WHERE ID_AGRICULTOR=?";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, agricultor.getNome());
        p.setObject(2, new java.sql.Date(agricultor.getData_cadastro().getTime()));
        p.setObject(3, agricultor.getMunicipio());
        p.setObject(4, agricultor.getLocalidade());
        p.setObject(5, agricultor.getProdutos());
        p.setObject(6, agricultor.getStatus());
        p.setObject(7, agricultor.getTelefone());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

