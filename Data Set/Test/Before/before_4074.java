class Dummy {
    public String getComentario(String tarea) {
        String comentario = "";
        String nomTarea = tarea;
        Connection conexion = null;
        try {
            conexion = getConeccion();
            String sql = "SELECT COMENTARIO FROM TAREAS WHERE DESCRIPCION = " + nomTarea;
            Statement coment = conexion.createStatement();
            ResultSet resultado = coment.executeQuery(sql);
            while (resultado.next()) {
                comentario = resultado.getString("COMENTARIO");
            }
            resultado.close();
            coment.close();
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
        return comentario;
    }
}
