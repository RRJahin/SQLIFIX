public class Dummy{
public void deleteNodo(Integer id_nodo) {
    try {
        open();
        String query = "delete from " + TBL_NAME + " where " + FIELD_ID + "="+id_nodo;
        st = conn.createStatement();
        st.executeUpdate(query);
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Eliminazione nodo");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

