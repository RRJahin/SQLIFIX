class Dummy{
@Test
public void cantidadDeAfiliacionesTest() throws SQLException {
    Connection conn = getConnection();
    Statement stmt = conn.createStatement();
    stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (99,'CC')");
stmt = conn.createStatement();
    stmt.execute("INSERT INTO `Usuario` (`nombre`, `clave`, `tipo`, `estado`, `identificacion`,`tipo_identificacion`,`fechaInicio`,`fechaFin`) VALUES ('UsuarioVencido', 'Usuario1', 'Estudiante', 'Ok', 99,'CC','2014-11-12','2015-11-12')");
stmt = conn.createStatement();
    stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (999,'CC')");
stmt = conn.createStatement();
    stmt.execute("INSERT INTO `Usuario` (`nombre`, `clave`, `tipo`, `estado`, `identificacion`,`tipo_identificacion`,`fechaInicio`,`fechaFin`) VALUES ('UsuarioSinVencer', 'Usuario1', 'Estudiante', 'Ok', 999,'CC','2014-11-12','2017-11-12')");
stmt = conn.createStatement();
    stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (9999,'CC')");
stmt = conn.createStatement();
    stmt.execute("INSERT INTO `Usuario` (`nombre`, `clave`, `tipo`, `estado`, `identificacion`,`tipo_identificacion`,`fechaInicio`,`fechaFin`) VALUES ('UsuarioVencido2', 'Usuario1', 'Estudiante', 'Ok', 9999,'CC','2014-11-12','2015-01-12')");
stmt = conn.createStatement();
    stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (9990,'CC')");
stmt = conn.createStatement();
    stmt.execute("INSERT INTO `Usuario` (`nombre`, `clave`, `tipo`, `estado`, `identificacion`,`tipo_identificacion`,`fechaInicio`,`fechaFin`) VALUES ('UsuarioVencido3', 'Usuario1', 'Egresado', 'Ok', 9990,'CC','2014-11-12','2016-11-12')");
stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select count(nombre) from Usuario where DAY(fechafin) - DAY(SYSDATE()) BETWEEN 0 AND 30\n" + "        AND YEAR(SYSDATE()) = YEAR(fechafin)\n" + "        AND MONTH(SYSDATE()) = MONTH(fechafin) ");
    int resultado = 0;
    while (rs.next()) {
        resultado = rs.getInt(1);
    }
    conn.commit();
    conn.close();
    Servicios servicios = Servicios.getInstance("h2-applicationconfig.properties");
    List<Usuario> listaAfiliacionesPorVencer;
    try {
        listaAfiliacionesPorVencer = servicios.consultarUsuarios();
        assertEquals("No concuerdan la cantidad de afiliaciones por vencer", resultado, listaAfiliacionesPorVencer.size());
    } catch (PersistenceException ex) {
        assertTrue("No se realizo adecuadamente la consulta de afiliaciones por vencer", false);
    }
}}

