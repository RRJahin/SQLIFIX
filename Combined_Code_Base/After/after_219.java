public class Dummy{
public void deleteNodo(Integer id_nodo) {
    try {
        open();
        String query = "delete from ? where ?=?";
        st = conn.prepareStatement(query);
        st.setObject(1,TBL_NAME);
        st.setObject(2,FIELD_ID ) ;
        st.setObject(3, id_nodo);
        st.executeUpdate();
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

