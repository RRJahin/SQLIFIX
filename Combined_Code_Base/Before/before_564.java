class Dummy{
public void addBudget(ResursaFinanciara res, Task t, Connection con) throws SQLException {
    
    Statement stmt = con.createStatement();
    int tip = 1;
    if (res.getTip().equals(ResursaFinanciara.TipCheltuiala.CHELTUIALA_CU_MANOPERA)) {
        tip = 2;
    }
    if (res.getTip().equals(ResursaFinanciara.TipCheltuiala.CHELTUIALA_DE_LOGISTICA)) {
        tip = 3;
    }
    String query = "INSERT INTO TaskBudget VALUES ("+t.getId()+","+tip+","+res.getSuma()+","+res.getDescriere()+")";
    stmt.executeUpdate(query);
}}

