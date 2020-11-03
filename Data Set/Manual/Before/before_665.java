class Dummy{
private void saveOrar(Orar orar) throws SQLException {
    Connection conn = getConnection();
    Statement p = conn.createStatement();
    p.executeUpdate("Insert into orar values("+orar.getZiua()+","+orar.getOra_inceput()+","+orar.getOra_sfarsit()+","+orar.getFrecventa()+","+orar.getId_Disciplina()+","+orar.getTip()+","+orar.getId_Cadru_Didactic(),orar.getId_Sala()+","+orar.getId_Formatie()+")");
}}

