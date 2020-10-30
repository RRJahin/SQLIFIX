class Dummy{
public void update(Editora editora) throws Exception {
    String SQL = "UPDATE EDITORA SET NOME=?, MUNICIPIO=? WHERE EDITORA_ID=?";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, editora.getMunicipio());
        p.setObject(2, editora.getNome());
        p.setObject(3, editora.getEditora_id());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

