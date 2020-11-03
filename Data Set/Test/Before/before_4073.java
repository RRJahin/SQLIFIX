class Dummy {
    public int getNumTareas(ProyectoBO proyecto) {
        int numero = 0;
        Connection conexion = null;
        try {
            conexion = getConeccion();
            String sql = "SELECT * FROM TAREAS WHERE PROYECTO = " + proyecto.getNombre();
            Statement numTareas = conexion.createStatement();
            ResultSet resultado = numTareas.executeQuery(sql);
            numero = resultado.getRow();
            resultado.close();
            numTareas.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if ((conexion != null) && (!conexion.isClosed())) {
                    conexion.close();
                }
            } catch (Exception exc) {
                throw new RuntimeException(exc);
            }
        }
        return numero;
    }
}
