class Dummy{
public void addBudget(ResursaFinanciara res, Task t, Connection con) throws SQLException {
    String query = "INSERT INTO TaskBudget VALUES (?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(query);
    stmt.setObject(1, t.getId());
    int tip = 1;
    if (res.getTip().equals(ResursaFinanciara.TipCheltuiala.CHELTUIALA_CU_MANOPERA)) {
        tip = 2;
    }
    if (res.getTip().equals(ResursaFinanciara.TipCheltuiala.CHELTUIALA_DE_LOGISTICA)) {
        tip = 3;
    }
    stmt.setObject(2, tip);
    stmt.setObject(3, res.getSuma());
    stmt.setObject(4, res.getDescriere());
    stmt.executeUpdate();
}}

