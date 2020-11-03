public class Dummy{
public void mudarStatusPasta(FiltroCadPendencia filtro) {
    try {
        open();
        stmt = con.createStatement();
        int cadastro = stmt.executeUpdate("update adv_pendencia.tab_pasta set statusPasta = 'ocupado' where idPasta = "+filtro.getPasta());
        if (cadastro > 0) {
            System.out.println("--> Pasta alterada com sucesso!");
            new ExtensaoDao().buscarPendencia(filtro);
        } else {
            System.out.println("--> Erro ao alterar a pasta");
        }
        close();
    } catch (SQLException sql) {
        sql.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

