public class Dummy{
public void adiciona(Usuarios pessoa) {
    String sql = "INSERT INTO Usuarios" + "(nome,Login,senha,email) values("+pessoa.getNome()+","+pessoa.getLogin()+","+pessoa.getSenha()+","+pessoa.getEmail()+")";
    dStatement stmt = null;
    try {
        stmt = connection.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        System.out.println(pessoa.getNome());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        System.out.println(pessoa.getLogin());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        System.out.println(pessoa.getSenha());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        System.out.println(pessoa.getEmail());
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

