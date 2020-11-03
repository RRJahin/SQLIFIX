class Dummy {
    public void alterar(Produto camarote) throws SQLException {
        Connection con = util.Conexao.getConexao();
        String sql = "UPDATE ingresso SET local=" + camarote.getLocal() + ", datahora="
                + new java.sql.Date(camarote.getDataHora().getTime()) + ", lugar=" + camarote.getLugar()
                + ", quantidade=" + camarote.getQuantidade() + ", idcategoria=" + camarote.getCategoria().getId()
                + ", idtipoingresso=" + camarote.getTipoIngresso().getId() + ", valor=" + camarote.getValor()
                + " WHERE id=" + camarote.getId();
        Statement ps = con.createStatement();
        ps.executeUpdate(sql);
    }
}
