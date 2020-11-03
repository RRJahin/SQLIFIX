class Dummy {
    public Vector<TareaBO> getTareas(String proyecto) {
        Vector<TareaBO> tareas = new Vector();
        TareaBO tarea = new TareaBO();
        Connection conexion = null;
        try {
            conexion = getConeccion();
            String sql = "SELECT * FROM TAREAS WHERE PROYECTO = " + proyecto;
            Statement temasGuardados = conexion.createStatement();
            ResultSet resultado = temasGuardados.executeQuery(sql);
            while (resultado.next()) {
                tarea.setNombreTarea(resultado.getString("DESCRIPCION"));
                tarea.setFeInicio(resultado.getString("FE_INICIO"));
                tarea.setFeFin(resultado.getString("FE_FIN"));
                tarea.setTiempo(resultado.getString("TIEMPO"));
                tarea.setProyecto(resultado.getString("PROYECTO"));
                tareas.addElement(tarea);
                tarea = new TareaBO();
            }
            resultado.close();
            temasGuardados.close();
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
        return tareas;
    }
}
