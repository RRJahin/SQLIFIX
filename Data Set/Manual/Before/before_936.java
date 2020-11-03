public class Dummy{
@Override
public AtividadesFisicas buscarPorId(int codigoBusca) {
    AtividadesFisicas atividadesFisicas = null;
    Statement pstmt = null;
    ResultSet rs = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        pstmt = conexao.createStatement();
        rs = pstmt.executeQuery("SELECT * FROM T_HT_ATIVIDADE WHERE CD_ATIVIDADE = "+codigoBusca);
        if (rs.next()) {
            int cd_atividade = rs.getInt("cd_atividade");
            String ds_atividade = rs.getString("ds_atividade");
            int cd_usuario = rs.getInt("cd_usuario");
            java.sql.Date data = rs.getDate("dt_atividade");
            Calendar dt_atividade = Calendar.getInstance();
            dt_atividade.setTimeInMillis(data.getTime());
            atividadesFisicas = new AtividadesFisicas(cd_atividade, ds_atividade, cd_usuario, dt_atividade);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            pstmt.close();
            rs.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return atividadesFisicas;
}}

