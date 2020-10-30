class Dummy{
public void update(Emprestimo emprestimo) throws Exception {
    String SQL = "UPDATE EMPRESTIMO SET LIVRO_ID="+emprestimo.getStatus()+", ESTUDANTE_ID="+new java.sql.Date(emprestimo.getData_entrega().getTime())+", DATA_RETIRADA="+new java.sql.Date(emprestimo.getData_devolucao().getTime())+", DATA_DEVOLUCAO="+new java.sql.Date(emprestimo.getData_retirada().getTime())+", DATA_ENTREGA="+emprestimo.getEstudante().getEstudante_id()+", STATUS="+emprestimo.getLivro().getLivro_id()+" WHERE EMPRESTIMO_ID="+emprestimo.getEmprestimo_id(;
    try {
        Statement p = connection.createStatement();
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

