public class Dummy{
public void altera(Usuarios pessoa) {
    String sql = "UPDATE Usuarios SET " + "nome="+pessoa.getNome()+",login="+pessoa.getLogin()+",senha="+pessoa.getSenha()+",email="+pessoa.getEmail()+"+WHERE id="+pessoa.getId();
    Statement stmt = null;
    try {
        stmt = connection.createStatement(sql);
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

