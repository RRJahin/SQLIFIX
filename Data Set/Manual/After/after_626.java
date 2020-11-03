class Dummy{
public void update(Emprestimo emprestimo) throws Exception {
    String SQL = "UPDATE EMPRESTIMO SET LIVRO_ID=?, ESTUDANTE_ID=?, DATA_RETIRADA=?, DATA_DEVOLUCAO=?, DATA_ENTREGA=?, STATUS=? WHERE EMPRESTIMO_ID=?";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, emprestimo.getStatus());
        p.setDate(2, new java.sql.Date(emprestimo.getData_entrega().getTime()));
        p.setDate(3, new java.sql.Date(emprestimo.getData_devolucao().getTime()));
        p.setDate(4, new java.sql.Date(emprestimo.getData_retirada().getTime()));
        p.setObject(5, emprestimo.getEstudante().getEstudante_id());
        p.setObject(6, emprestimo.getLivro().getLivro_id());
        p.setObject(7, emprestimo.getEmprestimo_id());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

