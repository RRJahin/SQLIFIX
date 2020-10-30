public class Dummy{
private void saveState(State state) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement p = conn.prepareStatement("Insert into State_de_Functii values(?,?,?,?,?,?,?,?,?,?)");
    p.setObject(1, state.getIdCadruDidactic());
    p.setObject(2, state.getIdDisciplina());
    p.setObject(3, state.getIdSectia());
    p.setObject(4, state.getAn());
    p.setObject(5, state.getOreC1());
    p.setObject(6, state.getOreS1());
    p.setObject(7, state.getOreL1());
    p.setObject(8, state.getOreC2());
    p.setObject(9, state.getOreS2());
    p.setObject(10, state.getOreL2());
    p.executeUpdate();
}}

