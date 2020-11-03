class Dummy{
private static String getStatus(String jarFile) throws SQLException {
    String fn = "${FARRAGO_HOME}/plugin/" + jarFile;
    String outfile = FarragoProperties.instance().expandProperties(fn);
    File f = new File(outfile);
    if (f.exists()) {
        String ret = "DOWNLOADED";
        Connection conn = DriverManager.getConnection("jdbc:default:connection");
        String name = jarFile.replaceAll("\\.jar", "");
        String query = "SELECT name FROM localdb.sys_root.dba_jars WHERE " + "name = ? AND url IN (?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setObject(1, name);
        ps.setObject(2, fn);
        ps.setObject(3, "file:" + fn);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ret = "INSTALLED";
        }
        rs.close();
        ps.close();
        return ret;
    } else {
        return "AVAILABLE";
    }
}}

