class Dummy{
private void lisaaAuto() {
    String rekno = lukija.lueTeksti("Aseta uudelle autolle rekkari: ");
    String merkki = lukija.lueTeksti("Aseta uudelle autolle merkki: ");
    String malli = lukija.lueTeksti("Aseta uudelle autolle malli: ");
    int vuosi = lukija.lueKokonaisluku("Aseta uudelle autolle vuosimalli: ");
    if (merkki.length() > 1 && malli.length() > 1 && rekno.length() > 1) {
        sql = "INSERT INTO autot VALUES("+rekno+","+merkki+","+malli+","+ vuosi+")";
        try {
            con = yhdista();
            stmtPrep = con.createStatement();
            stmtPrep.executeUpdate(sql);
            con.close();
            listaaAutot();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}}

