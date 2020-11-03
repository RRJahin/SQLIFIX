class Dummy {
    public void nuevaTarea(TareaBO tarea) {
        Connection conexion = null;
        try {
            conexion = getConeccion();
            String sql2 = "UPDATE PROYECTOS SET NUM_TAREAS = NUM_TAREAS+1 WHERE DESCRIPCION = " + tarea.getProyecto();
            String sql3 = "UPDATE TAREAS SET COMENTARIO = " + tarea.getComentario() + " WHERE DESCRIPCION = "
                    + tarea.getNombreTarea();
            Statement agregarTarea = conexion.createStatement();
            Statement comentario = conexion.createStatement();
            int tareaRes = agregarTarea.executeUpdate(sql2);
            int comentarioRes = comentario.executeUpdate(sql3);
            agregarTarea.close();
            comentario.close();
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
    }
}
