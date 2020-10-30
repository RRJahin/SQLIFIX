class Dummy{
public void alterarTabPendencia(ConsultaBuscaModelo cpm) {
    try {
        open();
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEmissao = parser.parse(cpm.getDataEmisao());
        Date dataPrevisaoFechamento = parser.parse(cpm.getDataFechamento());
        java.sql.Date dataSqlEmissao = new java.sql.Date(dataEmissao.getTime());
        java.sql.Date dataSqlFechamento = new java.sql.Date(dataPrevisaoFechamento.getTime());
        System.out.println(dataSqlEmissao);
        System.out.println(dataSqlFechamento);
        stmt = con.prepareStatement("UPDATE adv_pendencia.tab_pedencia set nomependencia = ?, descPend = ?, statusPend = ?, datEmiPend = ?, datPrevFechamento =? where idPed = ?");
        stmt.setObject(1, cpm.getNomePendencia());
        stmt.setObject(2, cpm.getDescPendencia());
        stmt.setObject(3, cpm.getStatusPendencia());
        stmt.setDate(4, dataSqlEmissao);
        stmt.setDate(5, dataSqlFechamento);
        stmt.setObject(6, cpm.getIdPed());
        int fechamento = stmt.executeUpdate();
        if (fechamento > 0) {
            System.out.println("Alterado com sucesso!");
            new AlterarPendenciaConsulta().alterarPasta(cpm);
        } else {
            System.out.println("Erro ao fazer o update!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!", "Erro ao alterar informa��es da pend�ncia, tente novamente!"));
        }
        close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

