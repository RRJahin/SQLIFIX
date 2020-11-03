class Dummy {
    public boolean eliminarTarea(TareaBO tarea) {
        boolean eliminada = true;
        Connection conexion = null;
        try {
            conexion = getConeccion();
            String sql1 = "DELETE FROM TAREAS WHERE DESCRIPCION = " + tarea.getNombreTarea();
            String sql2 = "UPDATE PROYECTOS SET TIEMPO = SUBTIME(TIEMPO, " + tarea.getTiempo()
                    + ") WHERE DESCRIPCION = " + tarea.getProyecto();
            String sql3 = "UPDATE PROYECTOS SET NUM_TAREAS = NUM_TAREAS - 1 WHERE DESCRIPCION = " + tarea.getProyecto();
            String sql4 = "DELETE FROM TIEMPOS WHERE TAREA = " + tarea.getNombreTarea();
            Statement eliminar = conexion.createStatement();
            Statement horas = conexion.createStatement();
            Statement tareas = conexion.createStatement();
            Statement tiempos = conexion.createStatement();
            int eliminarRes = eliminar.executeUpdate(sql1);
            int horasRes = horas.executeUpdate(sql2);
            int tareasRes = tareas.executeUpdate(sql3);
            int tiempoRes = tiempos.executeUpdate(sql4);
            eliminar.close();
            horas.close();
            tareas.close();
            tiempos.close();
            if ((eliminarRes != 0) && (horasRes != 0) && (tareasRes != 0) && (tiempoRes >= 0)) {
                System.out.println("\nSe elimino la TAREA satisfactoriamente");
            } else {
                eliminada = false;
                System.out.println("\nSe produjo un error eliminando la TAREA");
            }
        } catch (Exception e) {
            eliminada = false;
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
        return eliminada;
    }
}
