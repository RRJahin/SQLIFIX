class Dummy{
public void alterarExtensao(ConsultaBuscaModelo cpm) {
    try {
        open();
        stmt = con.createStatement("update adv_pendencia.tab_extensao set descExtensao = "+cpm.getDescExtensao()+", obExtensao = "+cpm.getObsExtensao()+" where tab_pasta_idPasta = "+cpm.getIdPasta()+" and fk_idPendencia = "+cpm.getIdPed());
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

