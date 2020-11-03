class Dummy{
public BigDecimal geCurCanon(BigDecimal idvehiculo, BigDecimal idtipovehiculo) {
    BigDecimal salida = new BigDecimal("-9999");
    try {
        ResultSet rsToken = null;
        String cQuery = "select idcanon, formula from canones where idtipovehiculo = " + idtipovehiculo.toString() + " order by precedencia desc ";
        Statement statement = dbconn.createStatement();
        rsToken = statement.executeQuery(cQuery);
        while (rsToken != null && rsToken.next()) {
            String formula = rsToken.getString("formula");
            String resultadoFormula = evaluarCondicion(setFormula(formula, idvehiculo.toString()));
            if (resultadoFormula.equalsIgnoreCase("TRUE")) {
                salida = rsToken.getBigDecimal("idcanon");
                break;
            }
        }
    } catch (Exception ex) {
        log.error("geCurCanon(BigDecimal idvehiculo, BigDecimal idtipovehiculo) " + ex);
    }
    return salida;
}}

