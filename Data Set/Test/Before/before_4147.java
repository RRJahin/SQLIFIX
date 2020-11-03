class Dummy {
    public void alterar(Produto camarote) throws SQLException {
        Connection con = util.Conexao.getConexao();
        String sql = "UPDATE ingresso SET local=" + camarote.getLocal() + ", datahora="
                + new java.sql.Date(camarote.getDataHora().getTime()) + ", lugar=" + camarote.getLugar() + ", valor="
                + camarote.getValor() + " WHERE id=" + camarote.getId();
        Statement ps = con.createStatement();
        ps.executeUpdate(sql);
    }
}
