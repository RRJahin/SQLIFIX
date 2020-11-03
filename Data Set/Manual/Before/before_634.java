class Dummy{
public void delete(Estudante estudante) throws Exception {
    String SQL = "DELETE FROM ESTUDANTE WHERE ESTUDANTE_ID = "+estudante.getEstudante_id();
    try {
        Statement p = connection.createStatement(SQL);
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

