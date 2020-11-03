class Dummy{
public List<Emprestimo> findAll() throws Exception {
    List<Emprestimo> list = new ArrayList<>();
    Emprestimo objeto;
    String SQL = "SELECT EMPRESTIMO.*, LIVRO.LIVRO_ID, ESTUDANTE.ESTUDANTE_ID " + "FROM EMPRESTIMO " + "INNER JOIN LIVRO ON (LIVRO.LIVRO_ID = EMPRESTIMO.LIVRO_ID) " + "INNER JOIN ESTUDANTE ON (ESTUDANTE.ESTUDANTE_ID = EMPRESTIMO.ESTUDANTE_ID) " + "WHERE EMPRESTIMO_ID = ?";
    try {
        Statement p = connection.createStatement();
        ResultSet rs = p.executeQuery(SQL);
        while (rs.next()) {
            objeto = new Emprestimo();
            objeto.setEmprestimo_id(rs.getInt("emprestimo_id"));
            objeto.setData_retirada(rs.getDate("data_retirada"));
            objeto.setData_devolucao(rs.getDate("data_devolucao"));
            objeto.setData_entrega(rs.getDate("data_entrega"));
            objeto.setStatus(rs.getString("status"));
            Livro livro = new Livro();
            livro.setLivro_id(rs.getInt("livro_id"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setAno(rs.getInt("ano"));
            livro.setDescricao(rs.getString("descricao"));
            Estudante estudante = new Estudante();
            estudante.setEstudante_id(rs.getInt("estudante_id"));
            estudante.setNome(rs.getString("nome"));
            estudante.setCurso(rs.getString("curso"));
            estudante.setData_matricula(rs.getDate("data_matricula"));
            estudante.setStatus(rs.getString("status"));
            objeto.setLivro(livro);
            objeto.setEstudante(estudante);
            list.add(objeto);
        }
        rs.close();
        p.close();
    } catch (SQLException ex) {
        throw new Exception(ex);
    }
    return list;
}}

