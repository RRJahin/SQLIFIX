public class Dummy{
public void altera(Notas nota) {
    String sql = "UPDATE Notas SET " + "aberta="+nota.getAberta()+",titulo="+nota.getTitulo()+", texto="+nota.getTexto()+", cor="+nota.getCor()+",prazo_final_nota="+new Date(nota.getPrazo_final().getTimeInMillis())+" WHERE id="+nota.getId();
    Statement stmt = null;
    try {
        stmt = connection.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.execute(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}

