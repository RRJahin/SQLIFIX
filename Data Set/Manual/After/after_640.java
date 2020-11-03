class Dummy{
public void alterarExtensao(ConsultaBuscaModelo cpm) {
    try {
        open();
        stmt = con.prepareStatement("update adv_pendencia.tab_extensao set descExtensao = ?, obExtensao = ? where tab_pasta_idPasta = ? and fk_idPendencia = ?");
        stmt.setObject(1, cpm.getDescExtensao());
        stmt.setObject(2, cpm.getObsExtensao());
        stmt.setObject(3, cpm.getIdPasta());
        stmt.setObject(4, cpm.getIdPed());
        int fechamento = stmt.executeUpdate();
        if (fechamento > 0) {
            System.out.println("Extens�o alterada com sucesso!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Sucesso!", "Dados alterados com sucesso!"));
        } else {
            System.out.println("Erro ao fazer o update!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Erro ao alterar extens�o, tente novamente!"));
        }
        close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

