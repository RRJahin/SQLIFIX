public class Dummy{
public void save(Agricultor agricultor) throws Exception {
    String SQL = "INSERT INTO CADASTROAGRICULTOR VALUES ("+agricultor.getId_agricultor()+", "+agricultor.getNome() +", "+new java.sql.Date(agricultor.getData_cadastro().getTime()))+", "+agricultor.getMunicipio()+", "+agricultor.getLocalidade()+", "+agricultor.getProdutos()+","+ agricultor.getStatus()+", "+agricultor.getTelefone()+")";
    try {
        Statement p = connection.createStatement();
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

