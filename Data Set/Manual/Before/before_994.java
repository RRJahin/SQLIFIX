public class Dummy{
public void cadastrarPendencia(FiltroCadPendencia filtro) {
    try {
        open();
        FormatarDatas dataF = new FormatarDatas();
        Date data = dataF.formatarData(filtro.getDataPrevPendencia());
        String sql = "INSERT INTO adv_pendencia.tab_pedencia VALUES(null, "+filtro.getDescPendencia()+",'Em aberto', "+filtro.getNomPendencia()+", null, "+filtro.getPasta()+","+data+")";
        stmt = con.createStatement();
        int retorno = stmt.executeUpdate(sql);
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

