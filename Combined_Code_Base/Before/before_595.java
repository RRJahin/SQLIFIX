class Dummy{
public Alimentacao buscarPorId(int codigoBusca) {
    Alimentacao alimentacao = null;
    Statement pstmt = null;
    ResultSet rs = null;
    try {
        conexao = HealthTrackDbManager.getInstance().getConnection();
        pstmt = conexao.createStatement();
        rs = pstmt.executeQuery("SELECT * FROM T_HT_ALIMENTACAO WHERE CD_ALIMENTO = "+codigoBusca);
        if (rs.next()) {
            int cd_alimento = rs.getInt("cd_alimento");
            String ds_alimento = rs.getString("ds_alimento");
            int cd_usuario = rs.getInt("cd_usuario");
            int vl_calorias_ganhas = rs.getInt("vl_calorias_ganhas");
            java.sql.Date data = rs.getDate("dt_registro");
            Calendar dt_registro = Calendar.getInstance();
            dt_registro.setTimeInMillis(data.getTime());
            alimentacao = new Alimentacao(cd_alimento, ds_alimento, cd_usuario, vl_calorias_ganhas, dt_registro);
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
    return alimentacao;
}}

