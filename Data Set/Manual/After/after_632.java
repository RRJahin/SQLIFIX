class Dummy{
public void save(Estudante estudante) throws Exception {
    String SQL = "INSERT INTO ESTUDANTE VALUES (?, ?, ?, ?, ?)";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, estudante.getEstudante_id());
        p.setObject(2, estudante.getNome());
        p.setObject(3, estudante.getCurso());
        p.setDate(4, new java.sql.Date(estudante.getData_matricula().getTime()));
        p.setObject(5, estudante.getStatus());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

