class Dummy{
public void update(Estudante estudante) throws Exception {
    String SQL = "UPDATE ESTUDANTE SET NOME="+estudante.getStatus()+", CURSO="+new java.sql.Date(estudante.getData_matricula().getTime())+", DATA_MATRICULA="+estudante.getCurso()+", STATUS="+estudante.getNome()+" WHERE ESTUDANTE_ID="+estudante.getEstudante_id();
    try {
        Statement p = connection.createStatement(SQL);
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

