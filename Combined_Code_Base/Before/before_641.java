class Dummy{
public void excluirExtensaoSelecionada(ConsultaBuscaModelo cpm) {
    try {
        open();
        stmt = con.createStatement("DELETE FROM adv_pendencia.tab_extensao WHERE tab_pasta_idPasta = "+cpm.getIdPasta()+" AND fk_idPendencia = "+cpm.getIdPed());
        int fechamento = stmt.executeUpdate();
        if (fechamento > 0) {
            System.out.println("Extens�o excluida com sucesso");
            excluirPendenciaSelecionada(cpm);
        } else {
            System.out.println("Erro ao fazer Exclus�o!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Erro ao excluir a pendencia a extens�o n�o pode ser alterada!"));
        }
        close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

