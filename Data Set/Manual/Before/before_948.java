public class Dummy{
public void mudarStatusPastaAberto(Pendencia pendencia) {
    try {
        open();
        stmt = con.createStatement();
        int pastaLivre = stmt.executeUpdate("update adv_pendencia.tab_pasta set statusPasta = 'livre' where idPasta = "+pendencia.getIdPasta());
        if (pastaLivre > 0) {
            System.out.println("Fechamento realizado com sucesso!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Sucesso!", "Fechamento realizado com sucesso!"));
        } else {
            System.out.println("--> Erro ao alterar a pasta");
        }
        close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}
