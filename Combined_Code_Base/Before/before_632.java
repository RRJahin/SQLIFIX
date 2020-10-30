class Dummy{
public void save(Estudante estudante) throws Exception {
    String SQL = "INSERT INTO ESTUDANTE VALUES ("+estudante.getEstudante_id()+", "+estudante.getNome()+", "+estudante.getCurso()+", "+new java.sql.Date(estudante.getData_matricula().getTime())+", "+estudante.getStatus()+")";
    try {
        Statement p = connection.createStatement(SQL);
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

