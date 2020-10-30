public class Dummy{
public void smodificaResursaFinanciara(ResursaFinanciara rf) throws Exception {
    Connection conn = getConnection();
    PreparedStatement p;
    try {
        p = conn.prepareStatement("UPDATE Resurse_Financiare  SET descriere=?, suma=?, tip=? where id=?");
        p.setObject(1, rf.getDescriere());
        p.setObject(2, rf.getSuma());
        int tip = 0;
        if (rf.getTip() != null) {
            switch(rf.getTip()) {
                case CHELTUIELA_CU_MOBILITATE:
                    tip = 1;
                    break;
                case CHELTUIALA_CU_MANOPERA:
                    tip = 2;
                    break;
                case CHELTUIALA_DE_LOGISTICA:
                    tip = 3;
                    break;
            }
        }
        p.setObject(3, tip);
        p.setObject(4, rf.getId());
        p.executeUpdate();
    } catch (SQLException e) {
        throw new Exception(e.getMessage());
    } finally {
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }
}}

