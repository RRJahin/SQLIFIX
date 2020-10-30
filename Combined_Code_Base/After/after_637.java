class Dummy{
public void adiciona(Notas nota) {
    String sql = "INSERT INTO Notas" + "(aberta,usuario_abriu,titulo,texto,cor,prazo_final_nota,data_criacao) values(?,?,?,?,?,?,?)";
    PreparedStatement stmt = null;
    try {
        stmt = connection.prepareStatement(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(1, nota.getAberta());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(2, nota.getUsuario_abriu());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(3, nota.getTitulo());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(4, nota.getTexto());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(5, nota.getCor());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setDate(6, new Date(nota.getPrazo_final().getTimeInMillis()));
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setDate(7, new Date(nota.getData_criacao().getTimeInMillis()));
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

