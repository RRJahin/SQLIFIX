class Dummy{
public void delete(Estudante estudante) throws Exception {
    String SQL = "DELETE FROM ESTUDANTE WHERE ESTUDANTE_ID = ?";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, estudante.getEstudante_id());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

