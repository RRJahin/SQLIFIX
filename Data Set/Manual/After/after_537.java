public class Dummy{
public void adiciona(Usuarios pessoa) {
    String sql = "INSERT INTO Usuarios" + "(nome,Login,senha,email) values(?,?,?,?)";
    PreparedStatement stmt = null;
    try {
        stmt = connection.prepareStatement(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        System.out.println(pessoa.getNome());
        stmt.setObject(1, pessoa.getNome());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        System.out.println(pessoa.getLogin());
        stmt.setObject(2, pessoa.getLogin());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        System.out.println(pessoa.getSenha());
        stmt.setObject(3, pessoa.getSenha());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        System.out.println(pessoa.getEmail());
        stmt.setObject(4, pessoa.getEmail());
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

