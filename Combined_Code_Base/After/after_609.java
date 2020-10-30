class Dummy{
public void save(Editora editora) throws Exception {
    String SQL = "INSERT INTO EDITORA VALUES (?, ?, ?)";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, editora.getEditora_id());
        p.setObject(2, editora.getNome());
        p.setObject(3, editora.getMunicipio());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

