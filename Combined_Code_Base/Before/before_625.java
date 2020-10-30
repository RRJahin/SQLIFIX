class Dummy{
public void save(Emprestimo emprestimo) throws Exception {
    String SQL = "INSERT INTO EMPRESTIMO VALUES ("+emprestimo.getEmprestimo_id()+", "+emprestimo.getLivro().getLivro_id()+", "+emprestimo.getEstudante().getEstudante_id()+", "+new java.sql.Date(emprestimo.getData_retirada().getTime())+", "+new java.sql.Date(emprestimo.getData_devolucao().getTime())+", "+new java.sql.Date(emprestimo.getData_entrega().getTime())+", "+ emprestimo.getStatus()+")";
    try {
        Statement p = connection.createStatement();
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

