class Dummy{
public void buscarPendencia(FiltroCadPendencia filtro) {
    try {
        open();
        stmt = con.prepareStatement("SELECT idPed FROM adv_pendencia.tab_pedencia where tab_pasta_idPasta = ?");
        stmt.setObject(1, filtro.getPasta());
        rs = stmt.executeQuery();
        ExtensaoPasta extensao = new ExtensaoPasta();
        while (rs.next()) {
            extensao.setIdPastaFK(rs.getInt("idPed"));
        }
        System.out.println(extensao.getIdPastaFK());
        cadastrarExtensao(filtro, extensao);
        close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

