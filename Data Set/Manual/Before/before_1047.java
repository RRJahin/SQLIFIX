public class Dummy{
public void update(String quota, Integer id_piano) {
    try {
        open();
        String query = "update " + TBL_NAME + " set " + FIELD_QUOTA + "="+quota+" where " + FIELD_ID + "="+id_piano;
        st = conn.createStatement();
        st.executeUpdate(query);
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Modifica piano");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

