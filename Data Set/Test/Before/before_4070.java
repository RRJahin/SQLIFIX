class Dummy {
    public boolean modificarNomTarea(String nuevoNombre, String nombre) {
        boolean modificada = true;
        Connection conexion = null;
        try {
            conexion = getConeccion();
            String sql1 = "UPDATE TAREAS SET DESCRIPCION = " + nuevoNombre + " WHERE DESCRIPCION = " + nombre;
            String sql2 = "UPDATE TIEMPOS SET TAREA = " + nuevoNombre + " WHERE TAREA = " + nombre;
            Statement modNombreTarea = conexion.createStatement();
            Statement modNombreTiempo = conexion.createStatement();
            int nombreRes = modNombreTarea.executeUpdate(sql1);
            int tiempoRes = modNombreTiempo.executeUpdate(sql2);
            modNombreTarea.close();
            modNombreTiempo.close();
            if ((nombreRes != 0) && (tiempoRes != 0)) {
                System.out.println("\nSe modifico la TAREA satisfactoriamente");
            } else {
                modificada = false;
                System.out.println("\nSe produjo un error modificando la TAREA");
            }
        } catch (Exception e) {
            modificada = false;
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
        return modificada;
    }
}
