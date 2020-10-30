public class Dummy{
public void update(Agricultor agricultor) throws Exception {
    String SQL = "UPDATE CADASTROAGRICULTOR SET NOME="+agricultor.getNome()+", DATA_CADASTRO="+new java.sql.Date(agricultor.getData_cadastro().getTime())+", MUNICIPIO="+agricultor.getMunicipio()+", LOCALIDADE="+agricultor.getLocalidade()+", PRODUTOS="+agricultor.getProdutos()+", STATUS="+agricultor.getStatus()+", TELEFONE="+agricultor.getTelefone()+" WHERE ID_AGRICULTOR=?";
    try {
        Statement p = connection.createStatement();
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

