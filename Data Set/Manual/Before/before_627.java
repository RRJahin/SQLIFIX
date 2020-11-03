class Dummy{
public void delete(Emprestimo emprestimo) throws Exception {
    String SQL = "DELETE FROM EMPRESTIMO WHERE EMPRESTIMO_ID = "+emprestimo.getEmprestimo_id();
    try {
        Statement p = connection.createStatement();
        p.execute(SQL);
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

