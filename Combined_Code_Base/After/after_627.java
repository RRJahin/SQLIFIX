class Dummy{
public void delete(Emprestimo emprestimo) throws Exception {
    String SQL = "DELETE FROM EMPRESTIMO WHERE EMPRESTIMO_ID = ?";
    try {
        PreparedStatement p = connection.prepareStatement(SQL);
        p.setObject(1, emprestimo.getEmprestimo_id());
        p.execute();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
}}

