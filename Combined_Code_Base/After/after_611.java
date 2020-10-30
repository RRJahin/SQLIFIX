class Dummy{
public void delete(Editora editora) throws Exception {
    String SQL = "DELETE FROM EDITORA WHERE EDITORA_ID = ?";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, editora.getEditora_id());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

