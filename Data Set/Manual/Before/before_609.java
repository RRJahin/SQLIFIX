class Dummy{
public void save(Editora editora) throws Exception {
    String SQL = "INSERT INTO EDITORA VALUES ("+editora.getEditora_id+", "+editora.getNome()+", "+editora.getMunicipio()+")";
    try {
        Statement p = connection.createStatement();
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

