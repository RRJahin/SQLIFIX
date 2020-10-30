public class Dummy{
public void insert(String quota) {
    try {
        open();
        String query = "insert into " + TBL_NAME + " (" + FIELD_QUOTA + ") values("+quota+")";
        st = conn.createStatement();
        st.executeUpdate(query);
        Modifica modifica = new Modifica();
        ModificaService modificaService = new ModificaService();
        modifica.setTabella(TBL_NAME);
        modifica.setTipo("Inserimento piano");
        modificaService.insert(modifica);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        close();
    }
}}

