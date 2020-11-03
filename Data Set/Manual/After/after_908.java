public class Dummy{
public int guardar(OrdenDeCompra oc) throws SQLException {
    String sql = null;
    if (oc.getIdordendecompra() == 0) {
        sql = "INSERT INTO public.ordendecompra(\n" + "	fechadeorden, idproveedor, centrodecostos, " + "contacto, concargoa, transportador, " + "numerodeguia, formadepago, " + "idusuario, observaciones, " + "iva, exentodeiva, valoriva)\n" + "	VALUES ('" + oc.getFechadeorden() + "', " + oc.getProveedor().getIdproveedor() + ", '" + oc.getCentrodecostos() + "', " + " '" + oc.getContacto() + "', '" + oc.getCargoflete() + "', '" + oc.getTransportador() + "', " + " '" + oc.getNumerodeguia() + "', '" + oc.getFormadepago() + "', " + " " + model.Usuario.getInstanceUser(0, null, null, null).getIdusuario() + ", '" + oc.getObservaciones() + "', " + " " + oc.getIva() + ", '" + oc.isExentodeiva() + "' , " + oc.getValoriva() + ");";
    } else {
        sql = "UPDATE public.ordendecompra SET " + "	fechadeorden='" + oc.getFechadeorden() + "', idproveedor=" + oc.getProveedor().getIdproveedor() + ", " + "centrodecostos='" + oc.getCentrodecostos() + "', " + "contacto='" + oc.getContacto() + "', concargoa='" + oc.getCargoflete() + "', " + "transportador='" + oc.getTransportador() + "', " + "numerodeguia='" + oc.getNumerodeguia() + "', formadepago='" + oc.getFormadepago() + "', " + "idusuario=" + model.Usuario.getInstanceUser(0, null, null, null).getIdusuario() + ", " + "observaciones='" + oc.getObservaciones() + "', " + "iva=" + oc.getIva() + ", exentodeiva='" + oc.isExentodeiva() + "' , valoriva=" + oc.getValoriva() + " " + "WHERE idordendecompra=" + oc.getIdordendecompra();
    }
    System.out.println(sql);
    PreparedStatement pst = con.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    if (pst.executeUpdate() > 0) {
        ResultSet rs = pst.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }
    return 0;
}}

