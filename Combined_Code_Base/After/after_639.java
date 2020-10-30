class Dummy{
public void altera(Notas nota) {
    String sql = "UPDATE Notas SET " + "aberta=?,titulo=?, texto=?, cor=?,prazo_final_nota=? WHERE id=?";
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
        stmt.setObject(2, nota.getTitulo());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(3, nota.getTexto());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(4, nota.getCor());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setDate(5, new Date(nota.getPrazo_final().getTimeInMillis()));
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.setObject(6, nota.getId());
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

