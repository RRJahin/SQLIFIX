public class Dummy{
public List<Pasta> getPasta() {
    try {
        open();
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT idPasta, descPasta FROM adv_pendencia.tab_pasta where statusPasta = 'livre'");
        List<Pasta> listaPasta = new ArrayList<Pasta>();
        while (rs.next()) {
            Pasta p = new Pasta();
            p.setIdPasta(rs.getInt("idPasta"));
            p.setDescPasta(rs.getString("descPasta"));
            listaPasta.add(p);
        }
        close();
        return listaPasta;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}}

