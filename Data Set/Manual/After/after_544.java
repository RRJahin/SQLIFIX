public class Dummy{
public List<Notas> getListaNota(String idlog) {
    List<Notas> notas = new ArrayList<Notas>();
    PreparedStatement stmt = null;
    try {
        stmt = connection.prepareStatement("SELECT * FROM Notas where usuario_abriu=?");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    Integer idl = Integer.parseInt(idlog);
    try {
        stmt.setObject(1, idl);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    ResultSet rs = null;
    try {
        rs = stmt.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        while (rs.next()) {
            Notas nota = new Notas();
            nota.setId(rs.getInt("id"));
            nota.setTitulo(rs.getString("titulo"));
            nota.setTexto(rs.getString("texto"));
            nota.setCor(rs.getString("cor"));
            Calendar cal = Calendar.getInstance();
            cal.setTime(rs.getDate("prazo_final_nota"));
            nota.setPrazo_final(cal);
            cal.setTime(rs.getDate("data_criacao"));
            nota.setData_criacao(cal);
            notas.add(nota);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        rs.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return notas;
}}
