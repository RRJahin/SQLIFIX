class Dummy{
public void excluirPendenciaSelecionada(ConsultaBuscaModelo cpm) {
    try {
        open();
        stmt = con.createStatement("DELETE FROM adv_pendencia.tab_pedencia WHERE idPed = "+cpm.getIdPed());
        int fechamento = stmt.executeUpdate();
        if (fechamento > 0) {
            System.out.println("pendencia excluida com sucesso");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Feito!", "Pendencia Excluida com sucesso!"));
        } else {
            System.out.println("Erro ao fazer Exclus�o!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Erro ao excluir a pendencia!"));
        }
        close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

