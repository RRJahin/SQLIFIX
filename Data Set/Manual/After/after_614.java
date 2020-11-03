class Dummy{
private void muutaAuto() {
    listaaAutot();
    String rekno = lukija.lueTeksti("Anna muutettavan auton rekno: ");
    sql = "SELECT * FROM autot WHERE rekno=?";
    try {
        con = yhdista();
        if (con != null) {
            stmtPrep = con.prepareStatement(sql);
            stmtPrep.setObject(1, rekno);
            rs = stmtPrep.executeQuery();
            if (rs.isBeforeFirst()) {
                String merkki = lukija.lueTeksti("Anna merkki: ");
                String malli = lukija.lueTeksti("Anna malli: ");
                int vuosi = lukija.lueKokonaisluku("Anna vmalli: ");
                if (merkki.length() > 1 && malli.length() > 1 && rekno.length() > 1) {
                    sql = "UPDATE autot SET merkki=?, malli=? vuosi=? WHERE rekno=?";
                    stmtPrep = con.prepareStatement(sql);
                    stmtPrep.setObject(1, rekno);
                    stmtPrep.setObject(2, merkki);
                    stmtPrep.setObject(3, malli);
                    stmtPrep.setObject(4, vuosi);
                    stmtPrep.executeUpdate();
                }
                con.close();
                listaaAutot();
            } else {
                System.out.println("Antamasi id ei ole k�yt�ss�!\n");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}}

