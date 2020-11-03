public class Dummy{
public void cadastrarPendencia(FiltroCadPendencia filtro) {
    try {
        open();
        FormatarDatas dataF = new FormatarDatas();
        Date data = dataF.formatarData(filtro.getDataPrevPendencia());
        String sql = "INSERT INTO adv_pendencia.tab_pedencia VALUES(null, ?,'Em aberto', ?, null, ?,?)";
        stmt = con.prepareStatement(sql);
        stmt.setObject(1, filtro.getDescPendencia());
        stmt.setObject(2, filtro.getNomPendencia());
        stmt.setObject(3, filtro.getPasta());
        stmt.setObject(4, data);
        int retorno = stmt.executeUpdate();
        if (retorno > 0) {
            System.out.println("dados inseridos com sucesso!");
            new PastaStatusAlterarDao().mudarStatusPasta(filtro);
        }
        close();
    } catch (SQLException sq) {
        throw new RuntimeException(sq);
    } catch (Exception e) {
        e.printStackTrace();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Erro interno!", "Por favor, contate o desenvolvedor! erro: " + e.getMessage()));
    }
}}

