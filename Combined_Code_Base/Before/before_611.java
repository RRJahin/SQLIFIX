class Dummy{
public void delete(Editora editora) throws Exception {
    String SQL = "DELETE FROM EDITORA WHERE EDITORA_ID = "+editora.getEditora_id();
    try {
        Statement p = connection.createStatement();
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

