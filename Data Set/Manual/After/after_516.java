public class Dummy{
public void save(Agricultor agricultor) throws Exception {
    String SQL = "INSERT INTO CADASTROAGRICULTOR VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, agricultor.getId_agricultor());
        p.setObject(2, agricultor.getNome());
        p.setObject(3, new java.sql.Date(agricultor.getData_cadastro().getTime()));
        p.setObject(4, agricultor.getMunicipio());
        p.setObject(5, agricultor.getLocalidade());
        p.setObject(6, agricultor.getProdutos());
        p.setObject(7, agricultor.getStatus());
        p.setObject(8, agricultor.getTelefone());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

