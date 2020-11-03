class Dummy{
public void save(Emprestimo emprestimo) throws Exception {
    String SQL = "INSERT INTO EMPRESTIMO VALUES (?, ?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, emprestimo.getEmprestimo_id());
        p.setObject(2, emprestimo.getLivro().getLivro_id());
        p.setObject(3, emprestimo.getEstudante().getEstudante_id());
        p.setDate(4, new java.sql.Date(emprestimo.getData_retirada().getTime()));
        p.setDate(5, new java.sql.Date(emprestimo.getData_devolucao().getTime()));
        p.setDate(6, new java.sql.Date(emprestimo.getData_entrega().getTime()));
        p.setObject(7, emprestimo.getStatus());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

