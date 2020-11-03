class Dummy{
public void update(Editora editora) throws Exception {
    String SQL = "UPDATE EDITORA SET NOME="+editora.getMunicipio()+", MUNICIPIO="+editora.getNome()+" WHERE EDITORA_ID="+editora.getEditora_id();
    try {
        Statement p = connection.createStatement();
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

