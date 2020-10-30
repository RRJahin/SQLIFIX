class Dummy{
private void poistaaAuto() {
    listaaAutot();
    String rekno = lukija.lueTeksti("Anna poistettavan auton rekkari: ");
    sql = "SELECT * FROM autot WHERE rekno=?";
    try {
        con = yhdista();
        if (con != null) {
            stmtPrep = con.prepareStatement(sql);
            stmtPrep.setObject(1, rekno);
            rs = stmtPrep.executeQuery();
            if (rs.isBeforeFirst()) {
                rs.next();
                if (lukija.lueTeksti("Haluatko varmasti poistaa kysisen auton " + rs.getString("rekno") + rs.getString("merkki") + " " + rs.getString("malli") + "(k/e): ").equalsIgnoreCase("k")) {
                    sql = "DELETE FROM autot WHERE rekno=?";
                    stmtPrep = con.prepareStatement(sql);
                    stmtPrep.setObject(1, rekno);
                    stmtPrep.executeUpdate();
                }
                con.close();
                listaaAutot();
            } else {
                System.out.println("Rekisterinumeroa vastaava auto ei l�ydy j�rjestelm�st� !\n");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("!!Auton poistaminen j�rjestelm�st� onnistui!! \n");
}}

