class Dummy{
public void excluirExtensaoSelecionada(ConsultaBuscaModelo cpm) {
    try {
        open();
        stmt = con.prepareStatement("DELETE FROM adv_pendencia.tab_extensao WHERE tab_pasta_idPasta = ? AND fk_idPendencia = ?");
        stmt.setObject(1, cpm.getIdPasta());
        stmt.setObject(2, cpm.getIdPed());
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

