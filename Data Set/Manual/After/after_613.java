class Dummy{
private void lisaaAuto() {
    String rekno = lukija.lueTeksti("Aseta uudelle autolle rekkari: ");
    String merkki = lukija.lueTeksti("Aseta uudelle autolle merkki: ");
    String malli = lukija.lueTeksti("Aseta uudelle autolle malli: ");
    int vuosi = lukija.lueKokonaisluku("Aseta uudelle autolle vuosimalli: ");
    if (merkki.length() > 1 && malli.length() > 1 && rekno.length() > 1) {
        sql = "INSERT INTO autot VALUES(?,?,?,?)";
        try {
            con = yhdista();
            stmtPrep = con.prepareStatement(sql);
            stmtPrep.setObject(1, rekno);
            stmtPrep.setObject(2, merkki);
            stmtPrep.setObject(3, malli);
            stmtPrep.setObject(4, vuosi);
            stmtPrep.executeUpdate();
            con.close();
            listaaAutot();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

