public class Dummy{
public void adiciona(Notas nota) {
    String sql = "INSERT INTO Notas" + "(aberta,usuario_abriu,titulo,texto,cor,prazo_final_nota,data_criacao) values("+nota.getAberta()+","+nota.getUsuario_abriu()+","+nota.getTitulo()+","+nota.getTexto()+","+nota.getCor()+","+ new Date(nota.getPrazo_final().getTimeInMillis())+","+new Date(nota.getData_criacao().getTimeInMillis())+")";
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

