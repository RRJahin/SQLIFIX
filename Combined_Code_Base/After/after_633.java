class Dummy{
public void update(Estudante estudante) throws Exception {
    String SQL = "UPDATE ESTUDANTE SET NOME=?, CURSO=?, DATA_MATRICULA=?, STATUS=? WHERE ESTUDANTE_ID=?";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, estudante.getStatus());
        p.setDate(2, new java.sql.Date(estudante.getData_matricula().getTime()));
        p.setObject(3, estudante.getCurso());
        p.setObject(4, estudante.getNome());
        p.setObject(5, estudante.getEstudante_id());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

